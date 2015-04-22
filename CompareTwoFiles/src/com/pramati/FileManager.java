package com.pramati;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FileManager implements FileManagerInterface {

	public void writeIntoTheFile(Set<String> partiallyMatchedData, String outPutFilePath) {

		try {

			File file = new File(outPutFilePath);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			for (String str : partiallyMatchedData) {
				bw.write(str + "\n");
			}
			
								
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
	}

	public Set<String> findPartiallyMatchedData(Set<String> contentOfFirstFile,
			Set<String> contentOfSecondFile) {

		Set<String> partiallyMatchedData = new HashSet<String>();
		Iterator<String> secondSetIterator = contentOfSecondFile.iterator();

		while (secondSetIterator.hasNext()) {
			String nameInSecondFile = secondSetIterator.next();
			String[] nameArray = nameInSecondFile.split(" ");
			String firstName = nameArray[0];
			String lastName = nameArray[nameArray.length - 1];
			Iterator<String> firstSetIterator = contentOfFirstFile.iterator();
			while (firstSetIterator.hasNext()) {
				String nameInFirstFile = firstSetIterator.next();
				if ((nameInFirstFile.startsWith(firstName) && nameInFirstFile
						.endsWith(lastName))) {
					partiallyMatchedData.add(nameInFirstFile);
				}
			}

		}

		return partiallyMatchedData;
	}

	public Set<String> readFile(String path) {
		
		Set<String> fileContent = new HashSet<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {

				fileContent.add(sCurrentLine.toUpperCase());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}

}