package com.pramati;


import java.util.Set;

public interface FileManagerInterface {

	public void writeIntoTheFile(Set<String> partiallyMatchedData, String outPutFilePath);

	public Set<String> findPartiallyMatchedData(Set<String> contentOfFirstFile,
			Set<String> contentOfSecondFile);

	public Set<String> readFile(String path);

}