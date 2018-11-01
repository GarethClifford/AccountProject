package com.qa.persistence.repo;

import static javax.transaction.Transactional.TxType.*;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountServiceDBImpl implements IConnect {
	@PersistenceContext(unitName = "primary") 
	private EntityManager em;
	@Inject
	private JSONUtil util;
	

	@Override
	public String getAllAccounts() {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a", Account.class);		
		return util.getJSONForObject(query.getResultList());
	}

	@Override
	public Account findAnAccount(Long id) {
		return em.find(Account.class, id);
	}
	
	@Inject
	IdChecker br;
	
	@Override
	@Transactional(REQUIRED)
	public String createAnAccount(String acc) {
		Account account = util.getObjectforJSON(acc, Account.class);
		if(br.checkIDNumber(account)) {
			em.persist(account);
			return "{\"message\": \"account sucessfully added\"}";
		}
		return "{\"message\": \"This account has been blocked\"}";
	}
	

	@Override
	@Transactional(REQUIRED)
	public String updateAnAccount(String account, Long id) {
		Account newDetials = util.getObjectforJSON(account, Account.class);
		Account oldDetails = em.find(Account.class, id);
		
		oldDetails.setFirstName(newDetials.getFirstName());
		oldDetails.setLastName(newDetials.getLastName());
		oldDetails.setAccountNumber(newDetials.getAccountNumber());
		
		return "{\"message\": \"account sucessfully updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		em.remove(findAnAccount(id));
		return "{\"message\": \"account sucessfully removed\"}";
	}

}
