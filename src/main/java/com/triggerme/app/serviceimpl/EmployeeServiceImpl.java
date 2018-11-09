package com.triggerme.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triggerme.app.dao.EmployeeRepository;
import com.triggerme.app.model.Employee;
import com.triggerme.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	public static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository emplRepository;

	@Override
	public Optional<Employee> findEmployeeById(String empId) {
		return emplRepository.findById(empId);
	}

	@Override
	public Employee saveEmployee(Employee empl) {
		return emplRepository.insert(empl);
	}

	@Override
	public Employee updateEmployee(Employee empl) {
		return emplRepository.save(empl);
	}

	@Override
	public List<Employee> getEmployees() {
		return emplRepository.findAll();
	}

}
