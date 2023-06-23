package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao empDao;
	
	@Override
	public List<Employee> getAllEmpsByDeptId(Long deptId) {
		
		return empDao.findByAssignedDeptId(deptId);
	}

	@Override
	public Employee authenticateEmp(String em, String pass) {
		
		return empDao.findByEmailAndPassword(em, pass);
	}

}
