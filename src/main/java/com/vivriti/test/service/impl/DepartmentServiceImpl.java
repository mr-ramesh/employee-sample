package com.vivriti.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivriti.test.exception.DataNotFoundException;
import com.vivriti.test.exception.DuplicateDataException;
import com.vivriti.test.model.Department;
import com.vivriti.test.repository.DepartmentRepository;
import com.vivriti.test.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository repo;

	@Override
	public Department create(Department department) throws DuplicateDataException {
		try {
			getByName(department.getDepartmentName());
			throw new DuplicateDataException("Department already existed with name " + department.getDepartmentName());
		} catch (DataNotFoundException e) {
			return repo.save(department);
		}
	}

	@Override
	public Department getByName(String departmentName) throws DataNotFoundException {
		return repo.findByDepartmentName(departmentName)
				.orElseThrow(() -> new DataNotFoundException("Department not found with name " + departmentName));
	}

	@Override
	public void deleteById(long id) throws DataNotFoundException {
		Department department = repo.findById(id).orElseThrow(() -> new DataNotFoundException());
		repo.deleteById(department.getDepartmentId());
	}

	@Override
	public List<Department> getAllDepartments() {
		return repo.findAll();
	}

}
