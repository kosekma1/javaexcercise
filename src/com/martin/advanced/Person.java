package com.martin.advanced;

import java.io.Serializable;

//to store persistent objects, they must implements Serializable interface  
public class Person implements Serializable {
	private String firstName, lastName;

	public Person() {
		super();
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
	
	public String toString() {
		return firstName + " " + lastName;
	}
	
	
}
