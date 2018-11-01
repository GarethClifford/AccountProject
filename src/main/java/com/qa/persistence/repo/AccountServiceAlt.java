package com.qa.persistence.repo;

import static javax.transaction.Transactional.TxType.*;

import java.util.Collection;
import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Alternative
public class AccountServiceAlt {
	private JSONUtil util;
	HashMap<Long, Account> accountMap = new HashMap<Long, Account>();

	public Collection<Account> getAllAccounts() {
		return accountMap.values();
	} 
	
	public Account findAnAccount(Long id) {
		return accountMap.get(id);
	}

	@Transactional(REQUIRED)
	public String createAnAccount(String acc) {
		Account account = util.getObjectforJSON(acc, Account.class);
		accountMap.put(account.getIDNumber(), account);
		return "{\"message\": \"account sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateAnAccount(Account account, Long id) {
		accountMap.put(id, account);
		return "{\"message\": \"account sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		accountMap.remove(id);
		return "{\"message\": \"account sucessfully deleted\"}";
	}


}
