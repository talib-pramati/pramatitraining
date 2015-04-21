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
		
		String url = webCrawler.getUniqueExtractedURLS().poll();
		try {
			
			extractURLS(url);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			System.out.println(url+ ", This url is unreachable");
			e.printStackTrace();
		}
		
	}

	public void extractURLS(String url) throws IOException {
		
		
		Document document = Jsoup.connect(url).get();
		Elements urls = document.select("a[href]");
		
		if(urls.isEmpty())
		{
			webCrawler.getPagesContainingNoLink().offer(url);
			webCrawler.startTextExtractorThread();
			//think to create new 
		}
		
		for(Element element:urls)
		{
			if(!webCrawler.isContainsURL(element.toString()))
			{
				webCrawler.getUniqueExtractedURLS().offer(element.attr("abs:href"));	
			}
				
		}
		
		webCrawler.newLinkExtractorThread();
		webCrawler.getVisitedLinks().add(url);
		
	}

}
