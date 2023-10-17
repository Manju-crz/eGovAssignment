package com.egov.api.master;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.egov.api.supporter.RequestBodyBuilder;
import com.egov.util.constants.Constant;
import com.egov.util.file.reader.PropertiesReader;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class Requester {
	
	protected Response response;
	private String responseBody;
	private int httpCode;
	
	protected String resourceURI;
	protected Map<String, Object> headers = new HashMap<String, Object>();
	protected Map<String, Object> parameters = new HashMap<String, Object>();
	protected String requestBody;
	
	RequestSpecification request = RestAssured.given();
	
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
		 request.baseUri(resourceURI);
		 return this;
	}
	
	public Requester setHeaders(Map<String, Object> requestEntityMapBuilder) {
		headers = requestEntityMapBuilder;
		request.headers(headers);
		return this;
	}

	public Requester setParameters(Map<String, Object> requestEntityMapBuilder) {
		parameters = requestEntityMapBuilder;
		request.params(parameters);
		return this;
	}
	
	public Requester setRequestBody(String jsonBodyText) {
		requestBody = jsonBodyText;
		request.body(requestBody);
		return this;
	}

	public Requester setQueryParameters(Map<String, Object> requestEntityMapBuilder) {
		request.queryParams(requestEntityMapBuilder);
		return this;
	}
	
}
