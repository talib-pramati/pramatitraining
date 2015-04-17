package processcrawling;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebCrawler implements WebCrwalerInterface{
	
	private final Set<String> visitedLinks= new HashSet<String>();
	private final Queue<String> uniqueExtractedURLS = new ConcurrentLinkedQueue<String>();
	
	private final Queue<String> pagesContainingNoLink = new ConcurrentLinkedQueue<String>();
	private ExecutorService executor;
	private String url;
	
	
	public WebCrawler(String startingURL, int maximum_threads)
	{
		this.url = startingURL;
		executor = Executors.newFixedThreadPool(maximum_threads);
		
	}
	public Queue<String> getUniqueExtractedURLS() {
		return uniqueExtractedURLS;
	}

	public Queue<String> getPagesContainingNoLink() {
		return pagesContainingNoLink;
	}

	public ExecutorService getExecutor() {
		return executor;
	}

	
	public void startCrawling()
	{
		uniqueExtractedURLS.offer(url);
		startLinkExtractorThread();
	}
	
	
	
	@Override
	public void newLinkExtractorThread() {
		
		startLinkExtractorThread();
		
	}
	
	@Override
	public void newTextExtractorThread(){
		
		startTextExtractorThread();
	}
	
	public void startLinkExtractorThread()
	{
		
		executor.execute(new LinkExtractor(this));
	}
	
	public void startTextExtractorThread()
	{
		executor.execute(new TextExtractor(this));
	}

	@Override
	public void addVisitedLinks(String url) {
		
		visitedLinks.add(url);
	}

	@Override
	public Boolean isContainsURL(String url) {
		// TODO Auto-generated method stub
		return visitedLinks.contains(url);
	}
	
	public Set<String> getVisitedLinks()
	{
		return this.visitedLinks;
	}

	

}
