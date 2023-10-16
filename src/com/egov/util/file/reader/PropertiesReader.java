package com.egov.util.file.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.egov.util.constants.Constant;

public class PropertiesReader {
	
	public String getProperty(String property) throws IOException {
		
	    FileInputStream fis = new FileInputStream(Constant.configPropertiesFile);
	    Properties prop = new Properties();
        prop.load(fis);
	    return prop.get(property).toString();
	}
	
	
	
}
