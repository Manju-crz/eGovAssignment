package com.egov.api.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.egov.api.master.Post;
import com.egov.api.master.Requester;
import com.egov.api.supporter.RequestBodyBuilder;
import com.egov.api.supporter.RequestEntityMapBuilder;


public class IndividualTest extends BaseTest{

	@Test
	public void individualCreateTest() throws IOException {
		String url = "/individual/v1/_create";
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
		System.out.println("Response body of Individual create is : " + requester.getResponseBody());
		Assert.assertEquals(requester.getHttpResponseCode(), 201, "Individual record creation is not responded with 201 http code");
	}
	

	@Test
	public void individualSearchTest() throws IOException {
		String url = "/individual/v1/_search";
		String jsonBody = new RequestBodyBuilder("IndividualSearch.json", holders)
				.setValue("authToken","RequestInfo", "authToken")
				.get();
		Requester requester = new Post()
				.setHeaders(new RequestEntityMapBuilder().set("Content-Type", "application/json").build())
				.setResourceURI(url)
				.setQueryParameters(new RequestEntityMapBuilder()
						.set("limit", 1000).set("offset", 0)
						.set("tenantId", "default").set("includeDeleted", true)
						.build())
				.setRequestBody(jsonBody)
				.request();
		System.out.println("Request body of Individual create is : " + jsonBody);
		System.out.println("Response body of Individual search is : " + requester.getResponseBody());
		Assert.assertEquals(requester.getHttpResponseCode(), 200, "Individual search http response code mis-matched!");
	}
	
	
	
	
}
