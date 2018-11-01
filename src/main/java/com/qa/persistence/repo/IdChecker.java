package com.qa.persistence.repo;

import com.qa.persistence.domain.Account;

public class IdChecker {

	public boolean checkIDNumber(Account account) {
		if (account.getAccountNumber().equals("9999")) {
			return false;
		} else
			return true;
	}
}
