package com.springdemo.SpringApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springdemo.SpringApp.model.Employee;
import com.springdemo.SpringApp.repository.EmployeeRepository;
import com.springdemo.SpringApp.service.EmployeeService;

import static org.mockito.Mockito.when;

@SpringBootTest
class SpringAppApplicationTests {
	
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepository repository;
	
	@Test
	public  void findAllTest(){
		 when(repository.findAll()).thenReturn(Stream.
				of(new Employee(1,"kapil","mahesh","maheshkumar@gmail.com"),new Employee(2,"chan","ku","cha@gmail.com")).collect(Collectors.toList()));
	assertEquals(2,service.findAll().size());
	}
		
	
}
