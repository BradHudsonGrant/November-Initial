package com.qa.business;

import java.util.List;

import com.qa.persistance.Account;

public interface AccountInterface {

	List<Account> getAllAccounts();

	Account addAccount(Account account);

	boolean updateAccount(long id, Account account);

	boolean deleteAccount(long id);
	
}
