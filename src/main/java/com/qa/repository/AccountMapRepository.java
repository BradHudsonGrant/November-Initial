package com.qa.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import com.qa.persistance.Account;

@ApplicationScoped
@Alternative
public class AccountMapRepository implements AccountRepo{

	private long counter = 1;
	private HashMap<Long, Account> accountMap;
	private long ID;
	
	public AccountMapRepository() {
		this.accountMap = new HashMap<Long, Account>();
		ID = counter;
	}

	public List<Account> getAllAccounts() {
		return new ArrayList<Account>(accountMap.values());
	}

	public Account createAccount(Account account) {
		ID++;
		accountMap.put(ID, account);
		return account;
	}

	public boolean updateAccount(long id, Account updatedAccount) {
		Account account = accountMap.get(id);
		account.setFirstName(updatedAccount.getFirstName());
		account.setLastName(updatedAccount.getLastName());
		return true;
	}

	public boolean deleteAccount(long id) {
		accountMap.remove(id);
		return true;
	}

}