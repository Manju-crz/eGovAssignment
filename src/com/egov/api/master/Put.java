package com.egov.api.master;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.specification.RequestSpecification;

public class Put extends Requester{

	@Override
	public Requester request() {
		RequestSpecification request = RestAssured.given();
		request.baseUri(resourceURI)
		.headers(headers)
		.params(parameters)
		.body(requestBody);
		response = request.put();
		return this;
	}

}
