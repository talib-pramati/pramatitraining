package startcrawler;

import processcrawling.WebCrawler;
import constantclassess.CrawlerConstants;

public class StartCrawler {
	
	
	public static void main(String[] args)
	{
		WebCrawler webCrawler = new WebCrawler(CrawlerConstants.SITE,CrawlerConstants.MAXIMUM_THREADS);
		webCrawler.startCrawling();
	}

}
