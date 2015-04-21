package processcrawling;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebCrawler implements WebCrwalerInterface{
	
	private final Set<String> visitedLinks= new HashSet<String>();
	private final Queue<String> uniqueExtractedURLS = new ConcurrentLinkedQueue<String>();
	
	private final Queue<String> pagesContainingNoLink = new ConcurrentLinkedQueue<String>();
	
	private final HandleFile handleFile = new HandleFile();
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
		executor.execute(new TextExtractor(this,handleFile));
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

	public void shutDownExecutorService()
	{
		if(uniqueExtractedURLS.isEmpty() && pagesContainingNoLink.isEmpty())
		{
			List<Runnable> shutdownNow = executor.shutdownNow();
			Iterator<Runnable> iterator = shutdownNow.iterator();
			
			while(iterator.hasNext())
			{
				System.out.println("This thread class running" + iterator.next().getClass());
			}
		}
	}

}
