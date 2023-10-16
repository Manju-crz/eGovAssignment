package com.egov.api.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.egov.api.master.Post;
import com.egov.api.master.Requester;
import com.egov.api.supporter.RequestBodyBuilder;
import com.egov.api.supporter.RequestEntityMapBuilder;


public class IndividualCreateTest extends BaseTest{

	String url = "/individual/v1/_create";
	
	@Test
	public void individualCreateTest() throws IOException {
		
		String jsonBody = new RequestBodyBuilder("IndividualCreate.json", holders)
				.setValue("authToken","RequestInfo", "authToken")
				.setValue("uuid", "UserRequest", "uuid")
				.get();
		Requester requester = new Post()
				.setHeaders(new RequestEntityMapBuilder().set("Content-Type", "application/json").build())
				.setResourceURI(url)
				.setRequestBody(jsonBody)
				.request();
		System.out.println("Request body of Individual create is : " + jsonBody);
		Assert.assertEquals(requester.getHttpResponseCode(), 201, "Individual record creation is not responded with 201 http code");
	}
	
	
}
