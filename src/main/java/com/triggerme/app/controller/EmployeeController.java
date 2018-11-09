package com.triggerme.app.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.triggerme.app.model.Employee;
import com.triggerme.app.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("tm")
@Slf4j
public class EmployeeController {

	public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService emplService;

	@RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET)
	public Optional<Employee> getUser(@RequestParam String emplId) {
		System.out.println(emplId);
		return emplService.findEmployeeById(emplId);
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee empl) {
		System.out.println(empl.toString());
		return new ResponseEntity<Employee>(emplService.saveEmployee(empl), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		return emplService.getEmployees();
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee empl) {
		return emplService.updateEmployee(empl);
	}

}
