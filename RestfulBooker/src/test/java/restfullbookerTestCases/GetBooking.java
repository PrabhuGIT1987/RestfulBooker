package restfullbookerTestCases;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetBooking {

	
	@Test
	public void getBookingDetails() {
		
		
		RequestSpecification reqSpec=RestAssured.given().log().all();
		
		
		reqSpec
			.baseUri("https://restful-booker.herokuapp.com")
			.basePath("/booking/{id}").pathParam("id", 255);
		
		Response response=reqSpec.get();
		
		ValidatableResponse vResponse=response.then().log().all();
			
		vResponse.statusCode(200);
		
		
		//BDD Style
		
	String result=RestAssured
			.given()
				.log().all()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/booking/{id}")
				.pathParam("id", 255)
			.when()
				.get()
			.then()
				.log().all()
				.statusCode(200)
				.extract()
				.path("firstname");
				
		
	System.out.println("--------------------------------");
		System.out.println("Result--"+result);
	}
	
	
}
