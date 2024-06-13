package com.studentapp.test.serenity;

import java.util.HashMap;

import com.studentapp.model.Students;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StudentSerinitySteps {

	
	@Step("Create Student using test Data==> firstName:{0} lastName:{1} program:{2} email:{3}")
	public ValidatableResponse createStudent(String firstName, String lastName, String program, String email) {
		
		
		Students std1=new Students(firstName,lastName,program,email);
		
		std1.setCourses("Java");
		std1.setCourses("Maths");
		std1.setCourses("DSP");
		
		
		ValidatableResponse response=SerenityRest
		.given().contentType(ContentType.JSON).log().all()
		.when().body(std1).post().then().log().all();
		
		return response;
		
	}
	
	@Step("Fetching student info using Program")
	public HashMap<String, Object> getStudentInfoByProgram(String program){
		
		
		String path1="find{it.programme=='";
		String path2="'}";
	
	HashMap<String, Object>	hmap=SerenityRest
		.given().contentType(ContentType.JSON).log().all()
		.when().get("/list").then().extract().path(path1+program+path2);

	return hmap;
		
	}
	
	
	@Step("Fetching student info using FirstName")
	public HashMap<String, Object> getStudentInfoByFirstName(String firstName){
	
		String path1="find{it.firstName=='";
		String path2="'}";
	
	HashMap<String, Object>	hmap=SerenityRest
		.given().contentType(ContentType.JSON).log().all()
		.when().get("/list").then().extract().path(path1+firstName+path2);

	return hmap;
		
	}
	
	
	@Step("Update Student Info using Data UpdatedfirstName:{0} UpdatedlastName:{1} program:{2} Updatedemail:{3} StudentID:{4}")
	public ValidatableResponse updateStudentInfo(String UpdatedfirstName, String UpdatedlastName, String program, String Updatedemail, int StudentID) {

		Students std1=new Students(UpdatedfirstName,UpdatedlastName,program,Updatedemail);
		
		std1.setCourses("Java");
		std1.setCourses("Maths");
		std1.setCourses("DSP");
		
		ValidatableResponse response=	SerenityRest
		.given().contentType(ContentType.JSON).log().all()
		.when().body(std1).put("/"+StudentID)
		.then().log().all();
		
		return response;
	}
	

	public HashMap<String, Object> getUpdatedStudentInfoByProgram(String program){
	
	
		String path1="find{it.programme=='";
		String path2="'}";
		
	//	System.out.println("Updated firstName--->"+UpdatedfirstName);
		HashMap<String, Object>	UpdatesStudentvalues=SerenityRest
				.given().contentType(ContentType.JSON).log().all()
				.when().get("/list").then().extract().path(path1+program+path2);
		
		return UpdatesStudentvalues;
	}
	
	@Step("Perform Student Delete using StudentID:{0}")
	public ValidatableResponse performStudentDelete(int StudentID) {
		
		ValidatableResponse response=SerenityRest
		.given().contentType(ContentType.JSON).log().all()
		.when().delete("/"+StudentID)
		.then().log().all();
		
		return response;
	}
	
}
