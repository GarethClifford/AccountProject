package com.qa.persistence.repo;

import com.qa.persistence.domain.Account;

public interface IConnect {

	String getAllAccounts();

	Account findAnAccount(Long id);

	String createAnAccount(String acc);

	String updateAnAccount(String account, Long id);

	String deleteAccount(Long id);

}