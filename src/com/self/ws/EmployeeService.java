package com.self.ws;

import com.self.bo.EmployeeBO;
import com.self.dto.EmployeeDTO;


/*Service layer where the request arrives
Create a wsdl of this layer > options > WebServices*/

public class EmployeeService {

	public EmployeeDTO getEmployeeInfo(String empId) {
		
		
		System.out.println("********Emp Service**********\n");
		EmployeeDTO empDto = null;
		try {
			if (empId != null && empId.trim().length() > 0) {

				EmployeeBO bo = new EmployeeBO();
				empDto = bo.getEmployeeInfo(empId);

			} else {
				System.out.println("Invalid input from the client");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Value of employee dto from Employee Service class: " + empDto);
		return empDto;
	}

	public String addEmployeeInfo(String empId) {
		System.out.println("Involking EmplyeeService addEmployee" + empId);
		return "success: " + empId;
	}

}
