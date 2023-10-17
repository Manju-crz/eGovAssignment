package com.egov.api.master;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post extends Requester {

	@Override
	public Requester request() {
		response = request.post();
		return this;
	}
	
}
