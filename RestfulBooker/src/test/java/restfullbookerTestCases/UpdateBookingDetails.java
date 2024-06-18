package restfullbookerTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateBookingDetails {

	
	@Test
	public void testPut() {
		
		PayLoads payload=new PayLoads();
		
		RestAssured
			.given()
				.log().all()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/booking/{bookingID}")
				.pathParam("bookingID", 6)
				.contentType(ContentType.JSON)
				.header("Accept", "application/json")
				.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.body(payload.getUpdateBookingDetaisRequestPayload())
			.when()
				.put()
			.then()
				.log().all()
				.assertThat()
				.statusCode(200);
		
		
	}
	
	
	
}
