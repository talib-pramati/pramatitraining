package processcrawling;

public interface WebCrwalerInterface {
	
	public void addVisitedLinks(String url);
	
	public Boolean isContainsURL(String url);
	
	public void newLinkExtractorThread();
	
	public void newTextExtractorThread();

}