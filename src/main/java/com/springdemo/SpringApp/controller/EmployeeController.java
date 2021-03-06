package com.springdemo.SpringApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.SpringApp.model.Employee;
import com.springdemo.SpringApp.repository.EmployeeRepository;
import com.springdemo.SpringApp.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;

	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		return employeeservice.findAll();
	}

	@PostMapping("/employee")
	public Employee createEmployee(@Validated @RequestBody Employee employee) {
		return employeeservice.save(employee);

	}

	@GetMapping("employee/{id}")
	public void getEmployeeById(@PathVariable(value = "id") long id) {
		employeeservice.findById(id);

	}

	@DeleteMapping("employee/{id}")
	public Employee deteteEmployee(@PathVariable(value = "id") long id) {
		return employeeservice.delete(id);
	}

}
