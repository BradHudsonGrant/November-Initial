package com.qa.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistance.Account;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public List<Account> getAllAccounts() {
		TypedQuery<Account> query = em.createQuery("Select a FROM Account a", Account.class);
		return query.getResultList();
	}

	private Account findAccount(Long id) {
		return em.find(Account.class, id);
	}
	
	@Transactional(REQUIRED)
	public boolean createAccount(Account account) {
		em.persist(account);
		return em.contains(account);
	}

	@Transactional(REQUIRED)
	public boolean updateAccount(Long id, Account updatedAccount) {
		Account oldAccount = em.find(Account.class, id);
		oldAccount.setFirstName(updatedAccount.getFirstName());
		oldAccount.setLastName(updatedAccount.getLastName());
		em.merge(oldAccount);
		return true;
	}

	@Transactional(REQUIRED)
	public boolean deleteAccount(Long id) {
		Account account = findAccount(id);
		em.remove(account);
		return em.contains(account);
	}
}