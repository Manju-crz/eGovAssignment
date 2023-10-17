package com.egov.api.master;

import java.util.Arrays;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Get extends Requester{

	@Override
	public Requester request() {
		response = request.get();
		return this;
	}
	
}
