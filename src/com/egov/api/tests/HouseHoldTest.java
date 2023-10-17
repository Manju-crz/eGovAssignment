package com.egov.api.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.egov.api.master.Get;
import com.egov.api.master.Post;
import com.egov.api.master.Requester;
import com.egov.api.response.ResponseExtractor;
import com.egov.api.supporter.RequestBodyBuilder;
import com.egov.api.supporter.RequestEntityMapBuilder;
import com.egov.api.supporter.ValueHolder;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HouseHoldTest extends BaseTest{
	
	@Test()
	public void householdCreateTest() throws IOException {
		String url = "/household/v1/_create";
		String jsonBody = new RequestBodyBuilder("HouseholdCreate.json", holders)
				.setValue("authToken","RequestInfo", "authToken")
				.setValue("uuid", "UserRequest", "uuid")
				.get();
		Requester requester = new Post()
				.setHeaders(new RequestEntityMapBuilder().set("Content-Type", "application/json").build())
				.setResourceURI(url)
				.setRequestBody(jsonBody)
				.request();
		Response httpResponse = requester.getHttpResponse();
		System.out.println("Request body of house hold create is : " + jsonBody);
		System.out.println("Response body of house hold create is : " + requester.getResponseBody());
		ResponseExtractor extractor = new ResponseExtractor(httpResponse);
		String id = extractor.getValue("Household.id");
		holders.add(ValueHolder.newHolder().set("Household", "id", id));
		String clientRefId =  extractor.getValue("Household.clientReferenceId");
		Assert.assertEquals(clientRefId, uuid, "clientReferenceId and UUID are mis-matching in the repsonse");
		Assert.assertEquals(requester.getHttpResponseCode(), 201, "House hold record creation is not responded with 201 http code");
	}
	
	
	@Test(dependsOnMethods={"householdCreateTest"})
	public void householdSearchTest() throws IOException {
		String url = "/household/v1/_search";
		String jsonBody = new RequestBodyBuilder("HouseholdSearch.json", holders)
				.setValue("authToken","RequestInfo", "authToken")
				.setValue("uuid", "UserRequest", "uuid")
				.get();
		Requester requester = new Post()
				.setHeaders(new RequestEntityMapBuilder().set("Content-Type", "application/json").build())
				.setResourceURI(url)
				.setQueryParameters(new RequestEntityMapBuilder()
						.set("limit", 100).set("offset", 0)
						.set("tenantId", "default").set("includeDeleted", true)
						.build())
				.setRequestBody(jsonBody)
				.request();
		Response httpResponse = requester.getHttpResponse();
		System.out.println("Request body of house hold search is : " + jsonBody);
		System.out.println("Response body of house hold search is : " + requester.getResponseBody());
		ResponseExtractor extractor = new ResponseExtractor(httpResponse);
		
		Assert.assertEquals(requester.getHttpResponseCode(), 200, "House hold search call http response code is mis-matched!");
	}
	
}
