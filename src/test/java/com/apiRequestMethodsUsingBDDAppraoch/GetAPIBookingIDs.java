package com.apiRequestMethodsUsingBDDAppraoch;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetAPIBookingIDs {

	@Test
	public void getAllBookingIds()
	{
		Response reponse = 
		RestAssured 
                  .given()
                      .contentType(ContentType.JSON)
                      .baseUri("https://restful-booker.herokuapp.com/booking")
                  .when()
                      .get()
                  .then()
                      .assertThat()
                      .statusCode(200)
                      .header("Content-Type", "application/json; charset=utf-8")
                      .extract().response();
                      //.body("bookingid[3]", Matchers.equalTo(1));
                      //.body("bookingid",Matchers.hasSize(100));
                      
		Assert.assertTrue(reponse.getBody().asString().contains("bookingid"));
	}
}
