package com.qa.business;

import java.util.List;

import javax.inject.Inject;

import com.qa.persistance.Account;
import com.qa.repository.AccountRepo;


public class AccountInterfaceImplement implements AccountInterface {

	@Inject
	private AccountRepo repo;

	public List<Account> getAllAccounts() {
		return repo.getAllAccounts();
	}

	public Account addAccount(Account account) {
		return repo.createAccount(account);
	}

	public boolean updateAccount(long id, Account account) {
		return repo.updateAccount(id, account);
	}

	public boolean deleteAccount(long id) {
		return repo.deleteAccount(id);

	}

}