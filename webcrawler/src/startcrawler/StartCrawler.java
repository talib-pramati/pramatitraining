package startcrawler;

import processcrawling.WebCrawler;
import constantclassess.ConstantClass;

public class StartCrawler {
	
	
	public static void main(String[] args)
	{
		WebCrawler webCrawler = new WebCrawler(ConstantClass.SITE,ConstantClass.MAXIMUM_THREADS);
		webCrawler.startCrawling();
		webCrawler.shutDownExecutorService();
	}

}
