package com.studentapp.model;

import java.util.ArrayList;
import java.util.List;

public class Students {
	public String firstName;
	public String lastName;
	public String programme;
	public String email;
	
	public List<String> courses;
	
	public Students(String firstName, String lastName, String programme, String email) {
		
		this.firstName=firstName;
		this.lastName=lastName;
		this.programme=programme;
		this.email=email;
	
		courses=new ArrayList<String>();
	}
	
	public List<String> getCourses() {
		return courses;
	}


	public void setCourses(String course) {
		courses.add(course);
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
