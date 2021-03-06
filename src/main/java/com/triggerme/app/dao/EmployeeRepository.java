package com.triggerme.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.triggerme.app.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
