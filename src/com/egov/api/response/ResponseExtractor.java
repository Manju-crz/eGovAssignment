package com.egov.api.response;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ResponseExtractor {
	
	private Response response;
	private ValidatableResponse  validatableResponse;
	
	public ResponseExtractor(Response response) {
		this.response = response;
		validatableResponse = response.then().contentType(ContentType.JSON);
	}
	
	public String getValue(String jsonPath) {
		return validatableResponse.extract().path(jsonPath).toString();
	}
	
	
	
}
