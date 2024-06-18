package restfullbookerTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBookingIDinBDDFormat {

	
	@Test
	public void create() {
		
		PayLoads payload=new PayLoads();
		
	int bookingID=RestAssured
						.given()
							.baseUri(null).basePath(null)
							.contentType(ContentType.JSON)
							.body(payload.getBookingIDRequestPayload())
							.log().all()
						.when()
							.post()
						.then()
							.log()
							.all()
							.statusCode(200)
							.extract()
							.path("bookingid");
							
							
		
		
		
	}
	
	
	
}
