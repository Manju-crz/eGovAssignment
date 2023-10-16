package com.egov.api.supporter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.egov.util.constants.Constant;
import com.egov.util.file.reader.TextFileReader;

public class RequestBodyBuilder {
	
	private static String resourcesFolderPath = Constant.resourcesDirectory;
	private String filePath;
	private List<ValueHolder> holders = new ArrayList<ValueHolder>();
	private String fileBodyText;
	private static String ob = "\\{";
	private static String cb = "\\}";
	
	public RequestBodyBuilder(String fileName, List<ValueHolder> holders) throws FileNotFoundException, IOException {
		this.holders = holders;
		filePath = Paths.get(resourcesFolderPath).resolve(Paths.get(fileName)).toString();
		fileBodyText = new TextFileReader(filePath).readFileContent();
	}
	
	public RequestBodyBuilder setValue(String replaceableVariable, String holderObjectType, String holderKey) {	
		for(ValueHolder holder : holders) {
			if(holder.getKey().toString().equalsIgnoreCase(replaceableVariable)) {
				String myKey = ob + ob + holder.getKey() + cb + cb;
				fileBodyText = fileBodyText.replaceAll(myKey, holder.getValue());
				return this;
			}
		}
		return this;
	}
	
	public String get() {
		return fileBodyText;
	}
	
}
