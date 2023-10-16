package com.egov.api.supporter;

import java.util.HashMap;
import java.util.Map;

public class RequestEntityMapBuilder {
	
	private static Map<String, Object> headers = new HashMap<>();
	
	public static RequestEntityMapBuilder newBuilder() {
		return new RequestEntityMapBuilder();
	}
	
	public RequestEntityMapBuilder set(String key, Object value) {
		headers.put(key, value);
		return this;
	}
	
	public Map<String, Object> build() {
		return headers;
	}
	
	
}
