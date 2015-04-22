package main;

import java.util.List;
import java.util.Set;

public interface FileManagerInterface {

	public void writeIntoTheFile(List<String> commonData);

	public List<String> compareContentofFile(Set<String> contentOfFirstFile,
			Set<String> contentOfSecondFile);

	public Set<String> readFile(String path, Set<String> contentFile);

}