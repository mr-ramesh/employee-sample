package com.vivriti.test.service;

import java.util.List;

import com.vivriti.test.exception.DataNotFoundException;
import com.vivriti.test.exception.DuplicateDataException;
import com.vivriti.test.model.Department;

public interface DepartmentService {

	Department create(Department department) throws DuplicateDataException;

	Department getByName(String departmentName) throws DataNotFoundException;

	void deleteById(long departmentId) throws DataNotFoundException;

	List<Department> getAllDepartments();

}
