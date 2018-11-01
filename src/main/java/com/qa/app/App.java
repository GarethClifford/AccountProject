package com.qa.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.service.AccountService;

public class App {

	public static void main(String[] args) {

		AccountService ac = new AccountService();

		ac.createAccount("1", "Andrew", "Knott");
		ac.createAccount("2", "Ben", "Taylor");
		ac.createAccount("3", "Gareth", "Clifford");
		ac.createAccount("4", "Harrison", "my Dude");

		try {
			ac.printTables();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
