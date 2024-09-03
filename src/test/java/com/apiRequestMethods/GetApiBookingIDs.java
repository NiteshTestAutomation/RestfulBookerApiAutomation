package com.apiRequestMethods;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetApiBookingIDs {

	@Test
	public void getAllBookingIds()
	{
		// Create a request specification
		RequestSpecification request = RestAssured.given();
		
		//Adding URI
		request.baseUri("https://restful-booker.herokuapp.com");
		
		// Calling GET method on URI. After hitting we get Response
		Response response = request.get("/booking");
		
		String apiRes = response.getBody().asPrettyString(); 
		
		// Let's print response body.
		System.out.println(apiRes);
		
		ValidatableResponse valResp = response.then();
		
		// Validate Response code
		valResp.statusCode(200);
		
		
	}
}
