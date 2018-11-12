package com.triggerme.app.service;

import java.util.List;
import java.util.Optional;

import com.triggerme.app.model.Employee;


public interface EmployeeService {

	Optional<Employee> findEmployeeById(String empId);

	Employee saveEmployee(Employee emp);

	Employee updateEmployee(Employee emp);
	
	List<Employee> getEmployees();

	boolean deleteEmployeeById(String empId);
}
