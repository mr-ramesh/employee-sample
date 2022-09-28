package com.vivriti.test.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long departmentId;

	@Column
	@NotBlank(message = "Department name is required for department creation")
	private String departmentName;

	@Column
	@NotBlank(message = "Department description is required for department creation")
	private String description;

	@OneToMany(targetEntity = Employee.class, fetch = FetchType.LAZY)
	private Set<Employee> employees;

}
