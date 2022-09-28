package com.vivriti.test.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeId;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String mobileNumber;

	@OneToOne(cascade = CascadeType.ALL, targetEntity = Address.class)
	private Address address;

	@ManyToOne(targetEntity = Department.class)
	private Department department;
}
