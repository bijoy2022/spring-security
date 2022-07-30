package com.myproject.springsecurity.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.springsecurity.model.Employee;

@RestController
@RequestMapping("/security")
public class MyController {
	
	
	@GetMapping("employee/{id}")
	public @ResponseBody Employee getEmployee(@PathVariable Integer id) {
		
		
		List<Employee> emp= Employee.getEmployees().stream().filter(e->e.getId().equals(id)).collect(Collectors.toList());
		
		return emp.get(0);
		
		
	}
	
	

	@GetMapping("employeeIdWithName/{id}/name/{name}")
	@ResponseBody
	public  Employee getEmployeeidWithName(@PathVariable Integer id,@PathVariable String name) {
		
		
		List<Employee> emp= Employee.getEmployees().stream().filter(e->e.getId().equals(id)).collect(Collectors.toList());
		
		return emp.get(0);
		
		
	}
	
	
	
	

}
