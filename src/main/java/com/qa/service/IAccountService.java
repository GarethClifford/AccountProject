package com.qa.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.persistence.domain.Account;

public interface IAccountService {

	Account findAnAccount(Long accountNum);

	String createAnAccount(String account);
	
	String getAllAccounts();

	String updateAnAccount(Long id, String acc);

	String deleteAnAccount(Long id);

}