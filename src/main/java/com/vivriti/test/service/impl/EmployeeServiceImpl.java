package com.vivriti.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivriti.test.dto.EmployeeRegisterRequest;
import com.vivriti.test.exception.DataNotFoundException;
import com.vivriti.test.model.Department;
import com.vivriti.test.model.Employee;
import com.vivriti.test.repository.EmployeeRepository;
import com.vivriti.test.service.DepartmentService;
import com.vivriti.test.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repo;

	@Autowired
	DepartmentService departmentService;

	@Override
	public Employee create(EmployeeRegisterRequest employeeRequest) throws DataNotFoundException {
		try {
			Department department = departmentService.getByName(employeeRequest.getDepartmentName());

			Employee employee = new Employee();
			employee.setFirstName(employeeRequest.getFirstName());
			employee.setLastName(employeeRequest.getLastName());
			employee.setMobileNumber(employeeRequest.getMobileNumber());
			employee.setAddress(employeeRequest.getAddress());
			employee.setDepartment(department);

			return repo.save(employee);
		} catch (DataNotFoundException e) {
			throw e;
		}

	}

	public Employee updateFirstName(long id, String firstName) throws DataNotFoundException {
		Employee employee = repo.findById(id).orElseThrow(() -> new DataNotFoundException());
		employee.setFirstName(firstName);
		return repo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public void deleteById(long id) throws DataNotFoundException {
		Employee employee = repo.findById(id).orElseThrow(() -> new DataNotFoundException());
		repo.deleteById(employee.getEmployeeId());
	}

}
