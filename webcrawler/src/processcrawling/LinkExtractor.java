package processcrawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkExtractor implements Runnable{

	
	private WebCrawler webCrawler;
	
	LinkExtractor(WebCrawler webCrawler)
	{
		
		this.webCrawler = webCrawler;
	}
	
	@Override
	public void run() {
		
		if(!webCrawler.getUniqueExtractedURLS().isEmpty()){
			
			System.out.println("link size = "+ webCrawler.getUniqueExtractedURLS().size());
			System.out.println("mail size = "+ webCrawler.getPagesContainingNoLink().size());
			String url = webCrawler.getUniqueExtractedURLS().poll();
			try {
				
				extractURLS(url);
				
			} catch (IOException e) {
								
				System.out.println(url+ ", This url is unreachable");
				e.printStackTrace();
			}
		}
		
		
	}

	public void extractURLS(String url) throws IOException {
		
		
		Document document = Jsoup.connect(url).get();
		Elements urls = document.select("a[href]");
		webCrawler.getVisitedLinks().add(url);
		
		if(urls.isEmpty())
		{
			System.out.println("Calling link extractor...");
			webCrawler.getPagesContainingNoLink().offer(url);
			webCrawler.startTextExtractorThread();
			
		}
		
		else
		{	for(Element element:urls)
			{
				if(!webCrawler.isContainsURL(element.toString()))
				{
					webCrawler.getUniqueExtractedURLS().offer(element.attr("abs:href"));
					webCrawler.newLinkExtractorThread();
				}
					
			}
		}
		
		webCrawler.getVisitedLinks().add(url);
		//webCrawler.newLinkExtractorThread();
		
	}

}
