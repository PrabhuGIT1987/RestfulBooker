package com.BaseTest;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {

	@BeforeClass
	public static void init() {
		
		RestAssured.baseURI="http://localhost:8080";
		RestAssured.basePath="/student";
		
		
	}
	
	
	
}
