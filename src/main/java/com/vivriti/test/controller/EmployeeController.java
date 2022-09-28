package com.vivriti.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivriti.test.dto.EmployeeRegisterRequest;
import com.vivriti.test.exception.DataNotFoundException;
import com.vivriti.test.model.Employee;
import com.vivriti.test.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeRegisterRequest employeeRequest)
			throws DataNotFoundException {
		Employee employee = employeeService.create(employeeRequest);
		return ResponseEntity.ok(employee);
	}

	@PatchMapping(path = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateEmployeeById(@PathVariable long employeeId, @RequestParam String firstName)
			throws DataNotFoundException {
		Employee employee = employeeService.updateFirstName(employeeId, firstName);
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteEmployeeById(@RequestParam long employeeId) throws DataNotFoundException {
		employeeService.deleteById(employeeId);
		return ResponseEntity.ok("User Deleted Successfully");
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

}
