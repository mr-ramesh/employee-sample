package com.vivriti.test.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.vivriti.test.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRegisterRequest {

	@NotBlank(message = "Department name is required for employee registeration")
	private String departmentName;

	@NotBlank(message = "FirstName is required for employee registeration")
	private String firstName;

	@NotBlank(message = "LastName is required for employee registeration")
	private String lastName;

	@NotBlank(message = "Mobile number is required for employee registeration")
	private String mobileNumber;

	@Valid
	@NotNull
	private Address address;

}
