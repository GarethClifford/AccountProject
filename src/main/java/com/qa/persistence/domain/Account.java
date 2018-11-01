package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ID;
	@Column(length = 45)
	String firstName;
	@Column(length = 45)
	String lastName;
	@Column(length = 4)
	String accountNumber;


	public Account() {

	}

	public Account(String accountNumber, String fName, String lName) {
		firstName = fName;
		lastName = lName;
		this.accountNumber = accountNumber;
	}


	public String setFirstName(String name) {
		firstName = name;
		return "Name Changed";
	}
	
	public String setLastName(String name) {
		lastName = name;
		return "Name Changed";
	}
	public String setAccountNumber(String accountno) {
		accountNumber = accountno;
		return "Name Changed";
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	public Long getIDNumber() {
		return this.ID;
	}

	public String getName() {

		return firstName + " " + lastName;
	}

}
