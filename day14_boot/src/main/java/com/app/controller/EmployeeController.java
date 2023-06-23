package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	/*
	 * http://host:port/day14_boot/emp/list , method=post payload(req body) :
	 * dept_id=1
	 */
	
	//dep : service layer i/f
	@Autowired
	private EmployeeService empService;
	
	
	public EmployeeController() {
		System.out.println("in ctor of"+getClass());
	}
	
	
	//@RequestParam : annotation to bind incoming rq param --> method argument, does the parsing also ! Match the rq param name with method arg name : SC : Long dept_id=Long.parseLong(request.getParameter(dept_id))
	@PostMapping("/list")
	public String listEmpsByDept(@RequestParam Long dept_id,Model map)
	{//for sharing the rsult from ds to view layer
		System.out.println("in list emps by dept"+dept_id);
		map.addAttribute("emp_list",empService.getAllEmpsByDeptId(dept_id));
		return "/emp/list";//AVN : /WEB-INF/views/emp/list.jsp
	}
	
	
	//
	@GetMapping("/signin")
	public String showLoginForm()
	{
		System.out.println("in show login form");
		return "/emp/login";
	}
	
	@PostMapping("/signin")
	public String processLoginForm(@RequestParam String em, String pass, Model map)
	{
		System.out.println("in process login form"+em+" "+pass);
		Employee emp = empService.authenticateEmp(em, pass);
		if(emp == null)
		{
			return "/emp/login";
		}else {
			map.addAttribute("emps_dtls",emp);
			return "/emp/details";
		}
		
	}
	
	
	
}
