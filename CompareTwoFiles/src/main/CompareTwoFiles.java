package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CompareTwoFiles {
	
	public static void main(String args[])
	{
		
		String path1 = "Files/File1.txt";
		String path2 = "Files/File2.txt";
		
		
		Set<String> contentOfFirstFile = new HashSet<String>();
		contentOfFirstFile = readFile(path1,contentOfFirstFile);
		
		Set<String> contentOfSecondFile = new HashSet<String>();
		contentOfSecondFile = readFile(path2,contentOfSecondFile);
		
		List<String> commonData = new ArrayList<String>();
		
		commonData = compareContentofFile(contentOfFirstFile,contentOfSecondFile);
		
		for(String str: commonData)
		{
			System.out.println(str);
		}
		
		writeIntoTheFile(commonData);
		
		
	}

	private static void writeIntoTheFile(List<String> commonData) {
		
		try {
			 
			
			File file = new File("Files/result.txt");
 
			
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(String str:commonData)
			{
				bw.write(str + "\n");
			}
			bw.close();
 
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<String> compareContentofFile(
			Set<String> contentOfFirstFile, Set<String> contentOfSecondFile) {
		
		List<String> list = new ArrayList<String>();
		Iterator<String> iterator = contentOfFirstFile.iterator();
		
		while(iterator.hasNext())
		{
			String next = iterator.next();
			
			if(contentOfSecondFile.contains(next))
				list.add(next);
				
		}
		
		return list;
	}

	private static Set<String> readFile(String path1,
			Set<String> contentFile) {
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path1)))
		{
 
			String sCurrentLine;
 
			while ((sCurrentLine = br.readLine()) != null) {
				
				contentFile.add(sCurrentLine.toUpperCase());
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return contentFile;
	}

}