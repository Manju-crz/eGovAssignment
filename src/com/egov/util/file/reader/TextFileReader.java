package com.egov.util.file.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
	
	private File file = null;
	private BufferedReader br = null;
	
	public TextFileReader(String fileFullPath) throws FileNotFoundException{
		file = new File(fileFullPath);
		br = new BufferedReader(new FileReader(file));
	}
	
	public String readFileContent() throws IOException {
		String st = "";
		String oneLineText = "";

		do {
			st = st + oneLineText + "\n";
			oneLineText = br.readLine();
		} while (oneLineText != null);
		return st;
	}
	
}
