package com.StudentInfo;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.BaseTest.TestBase;
import com.studentapp.test.serenity.StudentSerinitySteps;
import com.utils.TestUtils;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@RunWith(SerenityRunner.class)
public class StudentCRUDTest extends TestBase {
	
	@Steps
	StudentSerinitySteps steps;
	
	
	static String Rvalue=TestUtils.getRandom();
	
	String firstName="TestFN"+Rvalue;
	String lastName="TestLN"+Rvalue;
	String email="test"+Rvalue+"@gmail.com";
	String program="CSE"+Rvalue;
	
	static int StudentID;
	
	@Title("TC001: Create Student TC")
	@Ignore
	@Test
	public void TC001() {

		
		steps.createStudent(firstName, lastName, program, email).statusCode(201);
	/*	
		Students std1=new Students(firstName,lastName,program,email);
		
		std1.setCourses("Java");
		std1.setCourses("Maths");
		std1.setCourses("DSP");
		
	String response=SerenityRest
		.given().contentType(ContentType.JSON).log().all()
		.when().body(std1).post()
		.then().statusCode(201).log().all().extract().body().asPrettyString();
		
	System.out.println(response);
	*/	
	}
	
	

	@Title("TC002: Verify the Created Student")
	@Ignore
	@Test
	public void TC002() {
	
		String path1="find{it.programme=='";
		String path2="'}";
		
		HashMap<String, Object>	hmap=steps.getStudentInfoByProgram(program);
		/*
	HashMap<String, Object>	hmap=SerenityRest
		.given().contentType(ContentType.JSON).log().all()
		.when().get("/list").then().extract().path(path1+program+path2);
		*/
		
		
	System.out.println(path1+program+path2);
	System.out.println("Map Content is as below----------------->");
	System.out.println(hmap);
	Assert.assertEquals(firstName, hmap.get("firstName"));
		StudentID=(int)hmap.get("id");
		
	System.out.println("Student ID created is-->"+StudentID);
	}
	
	@Title("TC003: Update Student TC")
	@Ignore
	@Test
	public void TC003() {
		
	String 	UpdatedfirstName=firstName+"_Updated";
	String	UpdatedlastName=lastName+"_Updated";
	String	Updatedemail="test_Updated"+Rvalue+"@gmail.com";
	
	steps.updateStudentInfo(UpdatedfirstName, UpdatedlastName, program, Updatedemail, StudentID).statusCode(200);
	
	
	/*
	Students std1=new Students(UpdatedfirstName,UpdatedlastName,program,Updatedemail);
		
		std1.setCourses("Java");
		std1.setCourses("Maths");
		std1.setCourses("DSP");
		
	SerenityRest
		.given().contentType(ContentType.JSON).log().all()
		.when().body(std1).put("/"+StudentID)
		.then().statusCode(200).log().all();
	*/
	
		System.out.println("Verify the Updated Student details");
				
		String path1="find{it.programme=='";
		String path2="'}";
		
		System.out.println("Updated firstName--->"+UpdatedfirstName);
		
		
		HashMap<String, Object>	UpdatesStudentvalues=SerenityRest
				.given().contentType(ContentType.JSON).log().all()
				.when().get("/list").then().extract().path(path1+program+path2);
				
		
	
		
		System.out.println(path1+program+path2);		
		System.out.println("UpdatesMapvalues==>"+UpdatesStudentvalues);

		Assert.assertEquals(UpdatedfirstName, UpdatesStudentvalues.get("firstName"));
	}
	
	
	@Title("TC004: Delete created Student TC")
	@Ignore
	@Test
	public void TC004() {
		
		/*
		SerenityRest
		.given().contentType(ContentType.JSON).log().all()
		.when().delete("/"+StudentID)
		.then().statusCode(204).log().all();
		*/
		
		steps.performStudentDelete(StudentID).statusCode(204);
		
		SerenityRest
		.given().contentType(ContentType.JSON).log().all()
		.when().get("/"+StudentID)
		.then().statusCode(404).log().all();
		
		
	}
	
	
	
}
