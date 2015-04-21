package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompareTwoFiles {
	
	public static void main(String args[])
	{
		
		String firstFilePath = "Files/File1.txt";
		String secondFilepath = "Files/File2.txt";
		
		ManageFile mangeFile = new ManageFile();
		
		
		Set<String> contentOfFirstFile = new HashSet<String>();
		contentOfFirstFile = mangeFile.readFile(firstFilePath,contentOfFirstFile);
		
		Set<String> contentOfSecondFile = new HashSet<String>();
		contentOfSecondFile = mangeFile.readFile(secondFilepath,contentOfSecondFile);
		
		List<String> commonData = new ArrayList<String>();
		
		commonData = mangeFile.compareContentofFile(contentOfFirstFile,contentOfSecondFile);
		
		System.out.println("size = "+commonData.size());
		for(String str: commonData)
		{
			System.out.println(str);
		}
		mangeFile.writeIntoTheFile(commonData);
		
		
	}

	

}