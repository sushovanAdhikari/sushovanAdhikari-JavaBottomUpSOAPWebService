package com.self.bo;

import com.self.dto.EmployeeDTO;
import com.self.dao.EmployeeDAO;

/*Business Object layer has the business logic implemented 
*/
public class EmployeeBO {

	public EmployeeDTO getEmployeeInfo(String empId) {

		EmployeeDTO dto = null;

		if (empId != null && empId.trim().length() > 0) {

			EmployeeDAO dao = new EmployeeDAO();
			try {
				dto = dao.getEmployeeInfo(empId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Invalid input from the client");
		}

		return dto;
	}
}
