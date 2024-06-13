package com.BasicTestCases;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;


@RunWith(SerenityRunner.class)
public class FirstSerenityTest {


	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://localhost:8080";
		RestAssured.basePath="/student";
	}
	
	@Ignore
	@Test
	public void getAllStudents() {

		SerenityRest.given().contentType(ContentType.JSON).get("/list");
		
		
	}
	@Ignore
	@Test
	public void getSpecificStudent() {

		SerenityRest.given().when().contentType(ContentType.JSON).get("/20").then().log().all();
		
		
	}
	@Ignore
	@Test
	public void getSpecificStudentFailCase() {

		SerenityRest.given().when().contentType(ContentType.JSON).get("/20").then().log().all().statusCode(402);
		
		
	}

	
	
}
