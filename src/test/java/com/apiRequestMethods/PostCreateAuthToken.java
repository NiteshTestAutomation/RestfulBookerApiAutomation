package com.apiRequestMethods;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostCreateAuthToken {

	@Test
	public void createAuthToken()
	{
		
		String s = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
		
		RequestSpecification request = RestAssured.given();
		
		request.contentType(ContentType.JSON);
		
		request.baseUri("https://restful-booker.herokuapp.com/auth");
		
		request.body(s);
		
		Response response = request.post();
		
		System.out.println(response.asPrettyString());
		
		ValidatableResponse validateResponse = response.then();
		
		// Validate Response code
		validateResponse.statusCode(200);
		
		validateResponse.body("token",Matchers.notNullValue());
		
		validateResponse.body("token.length()",Matchers.is(15));
		
		validateResponse.body("token",Matchers.matchesRegex("^[a-z0-9]+$"));
	}
}
