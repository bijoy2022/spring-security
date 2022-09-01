package com.myproject.springsecurity.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.springsecurity.model.Employee;

public class DefaultController {
	
	
	@GetMapping("")
	public @ResponseBody Employee getEmployee(@PathVariable Integer id) {

		List<Employee> emp = Employee.getEmployees().stream().filter(e -> e.getId().equals(id))
				.collect(Collectors.toList());

		return emp.get(0);

	}

}
