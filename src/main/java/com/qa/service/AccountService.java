package com.qa.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repo.IConnect;

public class AccountService implements IAccountService {

	@Inject
	private IConnect connect;


	@Override
	public Account findAnAccount(Long accountNum) {
		return connect.findAnAccount(accountNum);
	}

	@Override
	public String createAnAccount(String account) {
		return connect.createAnAccount(account);
	}
	
	@Override
	public String getAllAccounts() {
		return connect.getAllAccounts();
				
	}
	
	@Override
	public String deleteAnAccount(Long id) {
		return connect.deleteAccount(id);
				
	}
	
	@Override
	public String updateAnAccount(Long id, String acc) {
		return connect.updateAnAccount(acc, id);
				
	}
	
}
