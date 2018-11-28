package com.triggerme.app.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triggerme.app.dao.EmployeeRepository;
import com.triggerme.app.model.Employee;
import com.triggerme.app.service.EmailService;
import com.triggerme.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository emplRepository;

	@Autowired
	EmailService emailService;

	@Override
	public Optional<Employee> findEmployeeById(String empId) {
		return emplRepository.findById(empId);
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return emplRepository.insert(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Employee oldEmpRecord = findEmployeeById(emp.getEmpId()).get();
		if (!emp.getStatusStartDate().equals(oldEmpRecord.getStatusStartDate()))
			emp.setIsEmpEVerifyStatus(false);
		else if (!emp.getStatusEndDate().equals(oldEmpRecord.getStatusEndDate()))
			emp.setIsEmpEVerifyStatus(false);
		else if (!emp.getProjectStartDate().equals(oldEmpRecord.getProjectStartDate()))
			emp.setIsEmpEVerifyStatus(false);
		else if (!emp.getProjectEndDate().equals(oldEmpRecord.getProjectEndDate()))
			emp.setIsEmpEVerifyStatus(false);
		else if (!emp.getEmpStartDate().equals(oldEmpRecord.getEmpStartDate()))
			emp.setIsEmpEVerifyStatus(false);
		else if (!emp.getEmpEndDate().equals(oldEmpRecord.getEmpEndDate()))
			emp.setIsEmpEVerifyStatus(false);
		return emplRepository.save(emp);
	}

	@Override
	public List<Employee> getEmployees() {
		return emplRepository.findAll();
	}

	@Override
	public void deleteEmployeeById(String empId) {
		emplRepository.deleteById(empId);
	}

	@Override
	public String sendEmpInactiveStatusNotfication() {
		List<Employee> inactiveStatusRecords = InactiveEmployeesFilter();
		// Send email notification of all inactive profiles to admin
		return emailService.postEMailNotification("tokishmail@gmail.com", inactiveStatusRecords.toString(), 1,
				"Action required: Inactive profiles found!");
	}

	private List<Employee> InactiveEmployeesFilter() {
		LocalDate today = LocalDate.now();
		List<Employee> inactiveStatusRecords = getEmployees().stream()
				.filter(emp -> checkIfInactiveProfileFound(emp, today)).collect(Collectors.toList());
		return inactiveStatusRecords;
	}

	private boolean checkIfInactiveProfileFound(Employee emp, LocalDate today) {
		if (emp.getStatusEndDate().compareTo(today) < 0)
			return true;
		if (emp.getProjectEndDate().compareTo(today) < 0)
			return true;
		if (emp.getEmpEndDate().compareTo(today) < 0)
			return true;
		if (!emp.isEmpEVerifyStatus())
			return true;
		return false;
	}

	@Override
	public List<Employee>  getInactiveEmployees() {
		return InactiveEmployeesFilter();
	}

}
