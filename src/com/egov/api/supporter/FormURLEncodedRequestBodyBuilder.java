package com.egov.api.supporter;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FormURLEncodedRequestBodyBuilder {
	
	private static Map<String, Object> headers = new HashMap<>();
	
	public static FormURLEncodedRequestBodyBuilder newBuilder() {
		return new FormURLEncodedRequestBodyBuilder();
	}
	
	public FormURLEncodedRequestBodyBuilder set(String key, Object value) {
		headers.put(key, value);
		return this;
	}

	public String build() {
		String output = "";
		for(String key : headers.keySet()) {
			output = output + URLEncoder.encode(key, StandardCharsets.UTF_8) + "=" +
							URLEncoder.encode((String) headers.get(key), StandardCharsets.UTF_8) + "&";
		}
		return output.substring(0, output.length()-1);
	}
	
}
