package test;


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;

public class TestingFile {
	
	public static void main(String[] args) throws IOException
	{
		File dir = new File("mails");
		
		if(!dir.exists())
		{
			dir.mkdir();
		}
		
		File filename = new File(dir,generateUniqueFileName());
		
		if(!filename.exists())
		{
			filename.createNewFile();
		}
		
		Charset charset = Charset.forName("US-ASCII");
		Path path = Paths.get(filename.getAbsolutePath());
		try(BufferedWriter writer = Files.newBufferedWriter(path, charset))
		{
			writer.write("Hi Talib", 0, "Hi Talib".length());
		}
		catch(Exception exc)
		{
			
		}
	}
	
	public static String generateUniqueFileName()
	{
		String DATE_FORMAT="yyyyMMdd_HHmmss-SSS";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		String todaysFormattedDate = sdf.format(new Date());
		
		Random random = new Random();
		int nextInt = random.nextInt(9999);
		
		String uniqueName = todaysFormattedDate + nextInt + ".txt";
		
		return uniqueName;
	}

	
}
