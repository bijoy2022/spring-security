package com.myproject.springsecurity.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.springsecurity.SpringSecurityApplication;
import com.myproject.springsecurity.model.Employee;

@RestController
//@RequestMapping("/security")
public class MyController {
	private static final Logger LOGGER = LogManager.getLogger(MyController.class);
	
	
	@GetMapping("/employee/{id}")
	public @ResponseBody Employee getEmployee(@PathVariable Integer id) {
		LOGGER.info("employee/{id called ----------------");
		List<Employee> emp = Employee.getEmployees().stream().filter(e -> e.getId().equals(id))
				.collect(Collectors.toList());

		return emp.get(0);

	}

	@GetMapping("employeeIdWithName/{id}/{name}")
	@ResponseBody
	public Employee getEmployeeidWithName(@PathVariable Integer id, @PathVariable String name) {
		LOGGER.info("employeeIdWithName/{id}/{name} called ----------------");
		List<Employee> emp = Employee.getEmployees().stream().filter(e -> e.getId().equals(id))
				.collect(Collectors.toList());

		return emp.get(0);

	}
	

	@GetMapping("queryParam/id")
	@ResponseBody
	public Employee queryParam(@RequestParam Integer id, @RequestParam String name) {

		List<Employee> emp = Employee.getEmployees().stream().filter(e -> e.getId().equals(id))
				.collect(Collectors.toList());

		return emp.get(0);

	}

	@GetMapping("pathWithRequestParam/employee/{id}")
	@ResponseBody
	public Employee pathWithRequestParam(@PathVariable Integer id, @RequestParam String name) {
System.out.println("pathWithRequestParam/employee/  "+id+ "   name  "+name);
		List<Employee> emp = Employee.getEmployees().stream().filter(e -> e.getId().equals(id))
				.collect(Collectors.toList());

		emp.get(0).setFirstName(name);

		return emp.get(0);

	}
	
	@GetMapping("employeeIdWithName/{id}/name/{name}")
	@ResponseBody
	public Employee getEmployeeidWithName2(@PathVariable Integer id, @PathVariable String name) {

		List<Employee> emp = Employee.getEmployees().stream().filter(e -> e.getId().equals(id))
				.collect(Collectors.toList());
		
		emp.get(0).setFirstName("employeeIdWithName/{id}/name/{name}");

		return emp.get(0);

	}
	
	@GetMapping("company/{sex}/cmp/{company}")
	@ResponseBody
	public List<Employee> getEmployeeidWithName22(@PathVariable String sex, @PathVariable String company,@RequestParam(required=false) String newVal) {

		List<Employee> emp = Employee.getEmployees().stream().filter(e -> e.getSex().equals(sex) && e.getCompany().equalsIgnoreCase(company))
				.collect(Collectors.toList());
		
		
		//System.out.println("request param value is ::"+newVal);
		//emp.get(0).setFirstName(company+sex);

		return emp;

	}

}
