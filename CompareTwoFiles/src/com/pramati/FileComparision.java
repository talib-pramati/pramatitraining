package com.pramati;


import java.util.Set;

public class FileComparision {

	public static void main(String args[]) {
		
		if(args.length < 2)
		{
			System.out.println("very few arguments");
			return;
		}

		String firstSourceFilePath = args[0];//"Files/File1.txt";
		String secondSourceFilepath = args[1];//"Files/File2.txt";
		String outPutFilePath = "File/result.text";//default path for output file
		
		if(args.length >2 && args[2] != null)
		{
			outPutFilePath = args[2];
		}

		FileManager fileManager = new FileManager();

		Set<String> contentOfFirstFile = fileManager.readFile(firstSourceFilePath);
		Set<String> contentOfSecondFile = fileManager.readFile(secondSourceFilepath);

		Set<String> partiallyMatchedData = fileManager.findPartiallyMatchedData(contentOfFirstFile,
				contentOfSecondFile);

		System.out.println("size = " + partiallyMatchedData.size());

		for (String str : partiallyMatchedData) {
			System.out.println(str);
		}

		fileManager.writeIntoTheFile(partiallyMatchedData,outPutFilePath);

	}

}