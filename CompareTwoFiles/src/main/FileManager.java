package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FileManager implements FileManagerInterface {

	public void writeIntoTheFile(List<String> commonData) {

		try {

			File file = new File("Files/result.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			for (String str : commonData) {
				bw.write(str + "\n");
			}
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> compareContentofFile(Set<String> contentOfFirstFile,
			Set<String> contentOfSecondFile) {

		List<String> list = new ArrayList<String>();
		Iterator<String> secondSetIterator = contentOfSecondFile.iterator();

		while (secondSetIterator.hasNext()) {
			String nameInSecondFile = secondSetIterator.next();
			String[] split = nameInSecondFile.split(" ");
			String firstName = split[0];
			String lastName = split[split.length - 1];
			Iterator<String> firstSetIterator = contentOfFirstFile.iterator();
			while (firstSetIterator.hasNext()) {
				String nameInFirstFile = firstSetIterator.next();
				if ((nameInFirstFile.startsWith(firstName) && nameInFirstFile
						.endsWith(lastName))) {
					list.add(nameInFirstFile);
				}
			}

		}

		return list;
	}

	public Set<String> readFile(String path, Set<String> fileContent) {

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