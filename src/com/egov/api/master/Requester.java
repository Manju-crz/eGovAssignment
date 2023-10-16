package com.egov.api.master;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.egov.api.supporter.RequestBodyBuilder;
import com.egov.util.constants.Constant;
import com.egov.util.file.reader.PropertiesReader;

import io.restassured.response.Response;

public abstract class Requester {
	
	protected Response response;
	private String responseBody;
	private int httpCode;
	
	protected String resourceURI;
	protected Map<String, Object> headers = new HashMap<String, Object>();
	protected Map<String, Object> parameters = new HashMap<String, Object>();
	protected String requestBody;
	
	public abstract Requester request();
	
	public int getHttpResponseCode() {
		return response.statusCode();
	}
	
	public String getResponseBody() {
		return response.body().asString();
	}

	public Response getHttpResponse() {
		return response;
	}
	
	public Requester setResourceURI(String uri) throws IOException {
		 resourceURI = Constant.serverEndpoint + uri;
		 return this;
	}
	
	public Requester setHeaders(Map<String, Object> requestEntityMapBuilder) {
		headers = requestEntityMapBuilder;
		return this;
	}

	public Requester setParameters(Map<String, Object> requestEntityMapBuilder) {
		headers = requestEntityMapBuilder;
		return this;
	}
	
	public Requester setRequestBody(String jsonBodyText) {
		requestBody = jsonBodyText;
		return this;
	}
	
	
	
}
