package com.BasicTestCases;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.BaseTest.TestBase;
import com.studentapp.model.Students;
import com.studentapp.test.serenity.StudentSerinitySteps;
import com.utils.TestUtils;

import io.restassured.http.ContentType;
import lombok.Getter;
import lombok.Setter;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@UseTestDataFrom("TestData/StudentData.csv")
@RunWith(SerenityParameterizedRunner.class)
public class DDTest extends TestBase {

	@Steps
	StudentSerinitySteps steps;

	static String Rvalue=TestUtils.getRandom();
	static int StudentID;

	@Getter @Setter String firstName;
	@Getter @Setter String lastName;
	@Getter @Setter String programme;
	@Getter @Setter String email;


	@Title("TC0001: Create Student with data parameter")
	@Test
	public void TC0001() {

		steps.createStudent(firstName, lastName, programme, email).statusCode(201);

	}
	
	  @Title("TC002: Verify the Created Student")
	  
	  @Test public void TC0002() {
	  
	  String path1="find{it.firstName=='"; String path2="'}";
	  
	  HashMap<String, Object> hmap=steps.getStudentInfoByFirstName(firstName);
	  
	  System.out.println(path1+firstName+path2);
	  System.out.println("Map Content is as below----------------->");
	  System.out.println(hmap); Assert.assertEquals(firstName,
	  hmap.get("firstName")); StudentID=(int)hmap.get("id");
	  
	  System.out.println("Student ID created is-->"+StudentID); 
	  
	  }
	  

		@Title("TC003: Update Student TC")
		@Test
		public void TC003() {
			
		String 	UpdatedfirstName=firstName+"_Updated";
		String	UpdatedlastName=lastName+"_Updated";
		String	Updatedemail="test_Updated"+Rvalue+"@gmail.com";
		
		steps.updateStudentInfo(UpdatedfirstName, UpdatedlastName, programme, Updatedemail, StudentID).statusCode(200);

			System.out.println("Verify the Updated Student details");
					
			String path1="find{it.firstName=='";
			String path2="'}";
			
			System.out.println("Updated firstName--->"+UpdatedfirstName);
			
			
			HashMap<String, Object>	UpdatesStudentvalues=SerenityRest
					.given().contentType(ContentType.JSON).log().all()
					.when().get("/list").then().extract().path(path1+UpdatedfirstName+path2);
	
			System.out.println(path1+UpdatedfirstName+path2);		
			System.out.println("UpdatesMapvalues==>"+UpdatesStudentvalues);

			Assert.assertEquals(UpdatedfirstName, UpdatesStudentvalues.get("firstName"));
		}
		
		@Title("TC004: Delete created Student TC")
		@Test
		public void TC004() {
			
			steps.performStudentDelete(StudentID).statusCode(204);
			
			SerenityRest
			.given().contentType(ContentType.JSON).log().all()
			.when().get("/"+StudentID)
			.then().statusCode(404).log().all();
		
		}
		
	 
}
