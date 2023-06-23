package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {
	//add a method to get list of emps
	List<Employee> getAllEmpsByDeptId(Long deptId);

	Employee authenticateEmp(String em, String pass);
	
}
