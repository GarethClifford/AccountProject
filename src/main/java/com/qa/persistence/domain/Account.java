package com.qa.persistence.domain;

import javax.persistence.Entity;

@Entity
public class Account extends Person {



	public Account() {

	}

	public Account(String accountNumber, String fName, String lName) {

		super.firstName = fName;
		super.lastName = lName;
		super.accountNumber = accountNumber;

	}


	public String setFirstName(String name) {

		super.firstName = name;

		return "Name Changed";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getAccountNumber() {
		return super.accountNumber;
	}

	public String getName() {

		return super.firstName + " " + super.lastName;
	}

}
