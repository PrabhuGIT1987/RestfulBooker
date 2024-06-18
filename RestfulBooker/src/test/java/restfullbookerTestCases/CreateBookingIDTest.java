package restfullbookerTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateBookingIDTest {

	
	@Test
	public void createBookingIDTest() {
		
		
		
		PayLoads payload=new PayLoads();
		/*
		//Create Request payload and set header parameters
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.baseUri("https://restful-booker.herokuapp.com");
		reqSpec.basePath("/booking");
		
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(payload.getBookingIDRequestPayload());
		
		//Call the post method to create new Booking id
		
		Response response=reqSpec.post();
		
		//validate response
		
		ValidatableResponse  vResponse =response.then();
		
		vResponse.statusCode(200);
		int bookingid=vResponse.extract().response().path("bookingid");
		System.out.println("booking id="+bookingid);
		
		*/
		
	int bookingID=	RestAssured
		.given()
			.baseUri("https://restful-booker.herokuapp.com")
			.basePath("/booking")
			.contentType(ContentType.JSON)
			.body(payload.getBookingIDRequestPayload())
			.log().all()
		.when()
			.post()
		.then()
			.log().all()
			.statusCode(200)
			.extract().response().path("bookingid");
		
	System.out.println("booking id="+bookingID);
	
	}
	
	
}
