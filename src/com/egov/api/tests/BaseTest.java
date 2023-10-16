package com.egov.api.tests;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import com.egov.api.supporter.FormURLEncodedRequestBodyBuilder;
import com.egov.api.supporter.ValueHolder;
import com.egov.util.constants.Constant;


public class BaseTest {
	
	protected static String accessToken;
	protected static String uuid;
	protected static List<ValueHolder> holders = new ArrayList<ValueHolder>();
	protected static String serverEndPoint = Constant.serverEndpoint;
	
	@BeforeSuite
	public void getAccessToken() throws IOException, InterruptedException {
		
		String url = serverEndPoint + "/user/oauth/token";
		FormURLEncodedRequestBodyBuilder bodyBuilder = FormURLEncodedRequestBodyBuilder.newBuilder()
				.set("username", "Distributor2").set("password", "eGov@1234")
				.set("grant_type", "password").set("scope", "read")
				.set("tenantId", "default").set("userType", "EMPLOYEE");

		HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .headers("accept", "*/*", "authorization", "Basic ZWdvdi11c2VyLWNsaWVudDo=", "content-type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(bodyBuilder.build()))
                .build();
        HttpResponse<?> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("response.body().toString()" + response.body().toString());
        
        String responseBodyJson =  response.body().toString();
        JSONObject jsonObject = new JSONObject(responseBodyJson);
        accessToken =  jsonObject.get("access_token").toString();
        uuid = new JSONObject(jsonObject.get("UserRequest").toString()).get("uuid").toString();
        
        holders.add(ValueHolder.newHolder().set("RequestInfo", "authToken", accessToken));
        holders.add(ValueHolder.newHolder().set("UserRequest", "uuid", uuid));
        
	}
	
	
}
