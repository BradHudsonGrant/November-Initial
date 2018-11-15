package com.qa.repository;

import java.util.HashMap;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistance.Account;
import com.qa.util.JSONUtility;


@Alternative
@ApplicationScoped
public class AccountMapRepository implements AccountRepo{

	@Inject
	private JSONUtility util;
	
	private long counter = 1;
	private HashMap<Long, Account> accountMap;
	private long ID;
	
	public AccountMapRepository() {
		this.accountMap = new HashMap<Long, Account>();
		ID = counter;
	}

	public String getAllAccounts() {
		return util.getJSONForObject(accountMap.values());
	}

	public String createAccount(String account) {
		ID++;
		Account newAccount = util.getObjectForJSON(account, Account.class);
		accountMap.put(ID, newAccount);
		return account;
	}

	public String updateAccount(long id, String updatedAccount) {
		Account account = util.getObjectForJSON(updatedAccount, Account.class);
		accountMap.put(id, account);
		return updatedAccount;
	}

	public String deleteAccount(long key) {
		accountMap.remove(key);
		return key + " Deleted";
	}

}