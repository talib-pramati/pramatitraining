package processcrawling;

import java.io.File;
import java.io.IOException;

public interface HandleFileInterface {
	
	public File creataeFile()  throws IOException ;
	
	public String generateUniqueFileName();
	
	public void writeIntoFile(File fileName,String text);

}
