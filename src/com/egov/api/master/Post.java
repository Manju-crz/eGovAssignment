package com.egov.api.master;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post extends Requester {

	@Override
	public Requester request() {
		RequestSpecification request = RestAssured.given();
		request.baseUri(resourceURI)
		.contentType(ContentType.URLENC)
		.headers(headers)
		.params(parameters)
		.body(requestBody);
		response = request.post();
		return this;
	}
	
}
