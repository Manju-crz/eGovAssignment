package com.egov.api.master;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Delete extends Requester{

	@Override
	public Requester request() {
		response = request.delete();
		return this;
	}

}
