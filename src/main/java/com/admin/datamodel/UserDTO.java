package com.admin.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "TBL_LOGIN")
@Data
public class UserDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "homeaddress")
	private String homeaddress;

	@Column(name = "city")
	private String city;

	@Column(name = "zipcode")
	private String zipcode;

	@Column(name = "country")
	private String country;

}
