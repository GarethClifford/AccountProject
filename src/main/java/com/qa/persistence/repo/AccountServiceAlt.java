package com.qa.persistence.repo;

import static javax.transaction.Transactional.TxType.*;

import java.util.Collection;
import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class AccountServiceAlt implements IConnect{
	private JSONUtil util;
	HashMap<Long, Account> accountMap = new HashMap<Long, Account>();
	
	public String getAllAccounts() {
		return accountMap.values().toString();
	} 
	
	public Account findAnAccount(Long id) {
		return accountMap.get(id);
	}
	
	@Inject
	IdChecker br;
	
	@Transactional(REQUIRED)
	public String createAnAccount(String acc) {
		Account account = util.getObjectforJSON(acc, Account.class);
		if(br.checkIDNumber(account)) {
			accountMap.put(account.getIDNumber(), account);
			return "{\"message\": \"account sucessfully added\"}";
		}
			return "{\"message\": \"This account has been blocked\"}";
		
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
