package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ID;
	@Column(length = 45)
	String firstName;
	@Column(length = 45)
	String lastName;
	@Column(length = 4)
	String accountNumber;

}
