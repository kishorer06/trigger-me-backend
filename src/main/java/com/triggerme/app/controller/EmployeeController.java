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
import com.triggerme.app.model.ResponseMessage;
import com.triggerme.app.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("tm")
public class EmployeeController {

	public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService emplService;

	@RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET)
	public Optional<Employee> getUser(@RequestParam String empId) {
		return emplService.findEmployeeById(empId);
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<Employee>(emplService.saveEmployee(emp), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		return emplService.getEmployees();
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PATCH)
	public Employee updateEmployee(@RequestBody Employee emp) {
		return emplService.updateEmployee(emp);
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseMessage> deleteEmployee(@RequestParam("empId") String empId) {
		ResponseEntity<ResponseMessage> response = null;

		try {
			emplService.deleteEmployeeById(empId);
			response = new ResponseEntity<ResponseMessage>(new ResponseMessage("Success"), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteEmployee: Failed!", e);
			response = new ResponseEntity<ResponseMessage>(new ResponseMessage("Error"), HttpStatus.NOT_FOUND);

		}
		return response;
	}
	
	@RequestMapping(value = "/getInactiveEmployees", method = RequestMethod.GET)
	public List<Employee> getInactiveEmployees() {
			return emplService.getInactiveEmployees();
	}

	@RequestMapping(value = "/sendEmpInactiveRecordsNotification", method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> sendEmpInactiveRecordsNotification() {
		ResponseEntity<ResponseMessage> response = null;
		String result = "";
		try {
			result = emplService.sendEmpInactiveStatusNotfication();
			response = new ResponseEntity<ResponseMessage>(new ResponseMessage("message: " + result), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("sendEmpInactiveRecordsNotification: Failed!", e);
			response = new ResponseEntity<ResponseMessage>(new ResponseMessage("message: " + result),
					HttpStatus.NOT_FOUND);
		}
		return response;
	}
}
