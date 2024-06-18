package restfullbookerTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PatchBookingDetails {

	
	@Test
	public void testPatch() {
		
		
		RestAssured
			.given()
				.log().all()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/booking/{bookingID}")
				.pathParam("bookingID", 6)
				.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"firstname\" : \"James1\",\r\n"
						+ "    \"lastname\" : \"Brown1\"\r\n"
						+ "}")
			.when()
				.patch()
			.then()
				.log().all()
				.statusCode(200);
			
		
		
	}
	
	
	
	
}
