package com.vivriti.test.service;

import java.util.List;

import com.vivriti.test.dto.EmployeeRegisterRequest;
import com.vivriti.test.exception.DataNotFoundException;
import com.vivriti.test.model.Employee;

public interface EmployeeService {

	Employee create(EmployeeRegisterRequest employeeRequest) throws DataNotFoundException;

	Employee updateFirstName(long id, String firstName) throws DataNotFoundException;

	void deleteById(long employeeId) throws DataNotFoundException;

	List<Employee> getAllEmployees();

}
