package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileComparision {

	public static void main(String args[]) {

		String firstFilePath = "Files/File1.txt";
		String secondFilepath = "Files/File2.txt";

		FileManager fileManager = new FileManager();

		Set<String> contentOfFirstFile = new HashSet<String>();
		contentOfFirstFile = fileManager.readFile(firstFilePath,
				contentOfFirstFile);

		Set<String> contentOfSecondFile = new HashSet<String>();
		contentOfSecondFile = fileManager.readFile(secondFilepath,
				contentOfSecondFile);

		List<String> commonData = new ArrayList<String>();

		commonData = fileManager.compareContentofFile(contentOfFirstFile,
				contentOfSecondFile);

		System.out.println("size = " + commonData.size());

		for (String str : commonData) {
			System.out.println(str);
		}

		fileManager.writeIntoTheFile(commonData);

	}

}