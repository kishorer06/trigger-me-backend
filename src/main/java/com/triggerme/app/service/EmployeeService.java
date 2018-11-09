package com.triggerme.app.service;

import java.util.List;
import java.util.Optional;

import com.triggerme.app.model.Employee;


public interface EmployeeService {

	Optional<Employee> findEmployeeById(String empId);

	Employee saveEmployee(Employee empl);

	Employee updateEmployee(Employee empl);
	
	List<Employee> getEmployees();
}
