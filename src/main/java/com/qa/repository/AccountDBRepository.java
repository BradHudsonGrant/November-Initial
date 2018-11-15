package com.qa.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistance.Account;
import com.qa.util.JSONUtility;

@Transactional(SUPPORTS)
@RequestScoped
@Default
public class AccountDBRepository {

	@Inject
	private JSONUtility util;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public String getAllAccounts() {
		Query query = em.createQuery("Select a FROM Account a");
		List<Account> account = (List<Account>) query.getResultList();
		return util.getJSONForObject(account);
	}

	private Account findAccount(Long id) {
		return em.find(Account.class, id);
	}
	
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		em.persist(anAccount);
		return "{\"MSG\": \"Account added\"}";
	}

	@Transactional(REQUIRED)
	public String updateAccount(Long id, String accountToUpdate) {
		Account updatedAccount = util.getObjectForJSON(accountToUpdate, Account.class);
		Account accountFromDB = findAccount(id);
		if (accountToUpdate != null) {
			accountFromDB = updatedAccount;
			em.merge(accountFromDB);
		}
		return "{\"MSG\": \"Account was updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			em.remove(accountInDB);
		}
		return "{\"MSG\": \"Account was deleted\"}";
	}
}