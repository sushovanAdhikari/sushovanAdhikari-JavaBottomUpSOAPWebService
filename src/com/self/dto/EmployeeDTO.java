package com.self.dto;

import java.io.Serializable;

@SuppressWarnings("serial")


/* DTO class is implenting Serializable to send dto across multiple layers. */

public class EmployeeDTO implements Serializable {

	private String empId;
	private String lastName;
	private String firstName;
	private String email;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
