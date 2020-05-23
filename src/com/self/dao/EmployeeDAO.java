package com.self.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.self.dto.EmployeeDTO;
import com.self.props.PropertiesHelper;


/*Data Access Object pattern working as a persitence layer
Calls to DB's here
*/
public class EmployeeDAO {

	// Connect to database from here
	// Look at Java API docs to learn more about the methods
	private Connection getCon() {

		Connection con = null;
		PropertiesHelper props = null;
		try {

			props = PropertiesHelper.getinstance();
			
			System.out.print(props.getProperty("driver"));
			
			// load driver
			Class.forName(props.getProperty("driver"));
			System.out.println("Driver Loaded \n");

			// step2 create the connection object
			con = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"),
					props.getProperty("password"));
			System.out.println("Database Sussfully Connected \n");
			con.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public EmployeeDTO getEmployeeInfo(String empId) throws Exception {

		// ??

		Statement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		EmployeeDTO empDto = null;

		try {
			
			con = getCon();
			// System.out.println("connnection value: " + con);
			stmt = con.createStatement();

			rs = stmt.executeQuery("select * from employees where employee_id=" + Integer.parseInt(empId));
			System.out.print("employee data: ");
			while (rs.next()) {

				empDto = new EmployeeDTO();

				String employeeId = rs.getString("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");
				System.out.println(empId + " " + firstName + " " + lastName + email + "\n");

				empDto.setEmpId(employeeId);
				empDto.setLastName(lastName);
				empDto.setFirstName(firstName);
				empDto.setEmail(email);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		System.out.println("Value of employee DTO from Employee DAO class : " + empDto + "\n");
		return empDto;

	}

}
