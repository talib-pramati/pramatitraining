package startcrawler;

import processcrawling.WebCrawler;
import constantclassess.ConstantClass;

public class StartCrawler {
	
	
	public static void main(String[] args)
	{
		new WebCrawler(ConstantClass.site,ConstantClass.maximum_threads).startCrawling();
	}

}
