package com.apiRequestMethodsUsingBDDAppraoch;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostCreateAuthToken {

	@Test
	public void createAuthToken()
	{
		String s = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
		
		RestAssured
		
		       .given()
		            .baseUri("https://restful-booker.herokuapp.com/auth")
		            .contentType(ContentType.JSON)
		            .body(s)
		       .when()
		            .post()
		       .then()
		            .assertThat()
		            .statusCode(200)
		        	.body("token", Matchers.notNullValue())
					.body("token.length()", Matchers.is(15))
					.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
		
	}
}
