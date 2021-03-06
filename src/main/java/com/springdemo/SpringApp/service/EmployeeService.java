package com.springdemo.SpringApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springdemo.SpringApp.model.Employee;
import com.springdemo.SpringApp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final Optional<Employee> List = null;
	@Autowired
	private EmployeeRepository repository;

	public Employee save(Employee employee) {
		return repository.save(employee);
	}

	// public Employee getEmployee() {
	// List<Employee> employee=repository.findAll();
	// return (Employee) employee;
	// }
	public List<Employee> findAll() {
		List<Employee> employee = repository.findAll();
		return employee;
	}

	public Optional<Employee> findById(long id) {
		Optional<Employee> employee = repository.findById(id);
		return employee;

	}

	public Employee delete(long id) {

		Employee emp = repository.findById(id).get();

		repository.deleteById(id);
		return emp;

	}

}
