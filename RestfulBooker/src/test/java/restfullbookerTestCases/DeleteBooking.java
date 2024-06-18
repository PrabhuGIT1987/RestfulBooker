package restfullbookerTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteBooking {

	@Test
	public void performDelete() {
		
		
		RestAssured
			.given()
				.log().all()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/booking/{bookingID}")
				.pathParam("bookingID",3246)
				.contentType(ContentType.JSON)
				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
			.when()
				.delete()
			.then()
				.log().all()
				.assertThat()
				.statusCode(200);
		
		
	}
	
}
