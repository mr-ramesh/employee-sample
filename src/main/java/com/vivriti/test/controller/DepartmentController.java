package com.vivriti.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivriti.test.exception.DataNotFoundException;
import com.vivriti.test.exception.DuplicateDataException;
import com.vivriti.test.model.Department;
import com.vivriti.test.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createDepartment(@Valid @RequestBody Department department) throws DuplicateDataException {
		Department createdDepartment = departmentService.create(department);
		return ResponseEntity.ok(createdDepartment);
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteDepartmentById(@RequestParam long departmentId) throws DataNotFoundException {
		departmentService.deleteById(departmentId);
		return ResponseEntity.ok("Department Deleted Successfully");
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllDepartments() {
		return ResponseEntity.ok(departmentService.getAllDepartments());
	}

	@GetMapping(path = "/{departmentName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getDepartmentByName(@PathVariable String departmentName) throws DataNotFoundException {
		return ResponseEntity.ok(departmentService.getByName(departmentName));
	}

}
