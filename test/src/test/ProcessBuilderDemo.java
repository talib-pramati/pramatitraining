package test;

import java.io.File;

public class ProcessBuilderDemo {
	
	 public static void main(String[] args) {

	      // create a new list of arguments for our process
	      String[] list = {"notepad.exe", "test.txt"};

	      // create the process builder
	      ProcessBuilder pb = new ProcessBuilder(list);

	      // set the working directory of the process
	      pb.directory(new File("C:/"));
	      System.out.println("" + pb.directory());
	   }

}
