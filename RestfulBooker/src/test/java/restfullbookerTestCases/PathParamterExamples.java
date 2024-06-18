package restfullbookerTestCases;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PathParamterExamples {

	@Test
	public void checkGetTestUsingPathParam() {
		
		RestAssured
		.given()
			.log().all()
			.baseUri("https://restful-booker.herokuapp.com")
			.basePath("/{bookPath}/{bookingId}")//named paramters
			.pathParam("bookPath", "booking")
			.pathParam("bookingId", 5)
			.contentType(ContentType.JSON)
		.when()
			.get()
		.then()
			.log().all()
			.statusCode(200);
	System.out.println("---------------------------Test2-------------------------------");		
		//inline parameter
		RestAssured
		.given()
			.log().all()
			.baseUri("https://restful-booker.herokuapp.com")
			.basePath("/{bookPath}/{bookingId}")
			.contentType(ContentType.JSON)
		.when()
			.get("https://restful-booker.herokuapp.com/{bookPath}/{bookingId}","booking",10)
		.then()
			.log().all()
			.statusCode(200);
		
		System.out.println("-------------------------Test3---------------------------------");		
		//inline parameter
		RestAssured
		.given()
			.log().all()
			.baseUri("https://restful-booker.herokuapp.com")
			.basePath("/{bookPath}/{bookingId}")
			.pathParam("bookPath", "booking")
			.contentType(ContentType.JSON)
		.when()
			.get("https://restful-booker.herokuapp.com/{bookPath}/{bookingId}",10)
		.then()
			.log().all()
			.statusCode(200);
		
		System.out.println("-------------------------Test4---------------------------------");		
		
		Map<String, Object> pathParameters=new HashMap<String, Object>();
		pathParameters.put("bookPath", "booking");
		pathParameters.put("bookingId", 6);
		
		RestAssured
			.given()
				.log().all()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/{bookPath}/{bookingId}")
				.pathParams(pathParameters)
				.contentType(ContentType.JSON)
			.when()
				.get()
			.then()
				.log()
				.all()
				.statusCode(200);
	}
	
	
}
