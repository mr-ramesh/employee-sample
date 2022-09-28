package com.vivriti.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressId;

	@Column
	@NotBlank(message = "House number and floor Name is required for employee registeration")
	private String houseNoAndFloorName;

	@Column
	@NotBlank(message = "Street Name is required for employee registeration")
	private String street;

	@Column
	private String area;

	@NotBlank(message = "City Name is required for employee registeration")
	private String city;

	@NotBlank(message = "State Name is required for employee registeration")
	private String state;

	@Column
	@NotNull(message = "Pincode is required for employee registeration")
	private Long pincode;
}
