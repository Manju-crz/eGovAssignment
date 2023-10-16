package com.egov.util.constants;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.egov.util.file.reader.PropertiesReader;

public class Constant {
	
	public static String projectDirectory = System.getProperty("user.dir");
	public static String configPropertiesFile ;
	public static String resourcesDirectory ;
	public static String serverEndpoint = null;
	static {
		Path resolvedPath = Paths.get(projectDirectory).resolve(Paths.get("Config.properties"));
		configPropertiesFile = resolvedPath.toString();
		resourcesDirectory =  Paths.get(projectDirectory).resolve(Paths.get("Resources")).toString();
		System.out.println("configPropertiesFile is : " + configPropertiesFile);
		try {
			serverEndpoint = new PropertiesReader().getProperty("ServerEndpoint");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
