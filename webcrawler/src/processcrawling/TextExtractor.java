package processcrawling;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TextExtractor implements Runnable{
	
	private WebCrawler webCrawler;
	private HandleFile handleFile;
	
	TextExtractor(WebCrawler webCrawler,HandleFile handleFile)
	{
		this.webCrawler = webCrawler;
		this.handleFile = handleFile;
	}
	
	@Override
	public void run()
	{
		if(!webCrawler.getPageContainsNoLink().isEmpty())
		{
			
			int size = webCrawler.getPageContainsNoLink().size();			
			String url = webCrawler.getPageContainsNoLink().poll();
			 Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
				try {
					
					Document doc = Jsoup.connect(url).get();
					Element text = doc.body();
					saveMail(text.text());
				} catch (IOException e) {
				
					System.out.println("This mail could not saved");
					e.printStackTrace();
			}
				
			webCrawler.newTextExtractorThread();
			
		}
		
	}
	
	
	public void saveMail(String mailText) throws IOException
	{
		File file = handleFile.creataeFile();
		handleFile.writeIntoFile(file, mailText);
	}

}
