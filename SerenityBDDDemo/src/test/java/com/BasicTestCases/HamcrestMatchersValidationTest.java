package com.BasicTestCases;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;


public class HamcrestMatchersValidationTest {

	///assertions in response body using hamcrest matchers
	@Ignore
	@Test
	public void createStudent() {
		
		RestAssured.baseURI="http://localhost:8080";
		RestAssured.basePath="/student/90";	
		
	SerenityRest
		.given().contentType(ContentType.JSON).log().all()
		.when().get()
		.then().body("firstName", equalTo("Channin1g")).log().all();
	
		
	
		
	}
	
	@Ignore
	@Test
	public void TestStudent() {
		
		RestAssured.baseURI="http://localhost:8080";
		RestAssured.basePath="/student";	
		
		HashMap<String, Object>	hmap=SerenityRest
		.given().contentType(ContentType.JSON).log().all()
		.when().get("/list")
		.then().extract().path("find{it.firstName=='Murphy'}");
	
	System.out.println("hmap="+hmap);
	
		//System.out.println("Id list="+id);
		
	}
}
