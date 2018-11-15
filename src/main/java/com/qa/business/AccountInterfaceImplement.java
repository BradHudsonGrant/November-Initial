package com.qa.business;

import javax.inject.Inject;

import com.qa.repository.AccountRepo;


public class AccountInterfaceImplement implements AccountInterface {

	@Inject
	private AccountRepo repo;

	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	public String addAccount(String account) {
		return repo.createAccount(account);
	}

	public String updateAccount(long id, String account) {
		return repo.updateAccount(id, account);
	}

	public String deleteAccount(long id) {
		return repo.deleteAccount(id);

	}

}