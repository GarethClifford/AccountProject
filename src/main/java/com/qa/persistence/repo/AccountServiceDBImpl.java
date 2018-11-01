package com.qa.persistence.repo;

import static javax.transaction.Transactional.TxType.*;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountServiceDBImpl {
	@PersistenceContext(unitName = "primary") 
	private EntityManager em;
	private JSONUtil util;
	
	public String getAllAccounts() {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM ACCOUNT a", Account.class);		
		return util.getJSONForObject(query.getResultList());
	}
	public Account findAnAccount(Long id) {
		return em.find(Account.class, id);
	}
	
	@Transactional(REQUIRED)
	public String createAnAccount(String acc) {
		Account account = util.getObjectforJSON(acc, Account.class);
		em.persist(account);
		return "{\"message\": \"account sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateAnAccount(Account account, Long id) {
		Account oldDetails = em.find(Account.class, id);
		
		oldDetails.setFirstName(account.getFirstName());
		oldDetails.setLastName(account.getLastName());
		oldDetails.setAccountNumber(account.getAccountNumber());
		
		return "{\"message\": \"account sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		em.remove(id);
		
		return "{\"message\": \"account sucessfully removed\"}";
	}

}
