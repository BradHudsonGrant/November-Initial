package com.qa.repository;

import java.util.List;

import com.qa.persistance.Account;

public interface AccountRepo {

	List<Account> getAllAccounts();

	Account createAccount(Account account);

	boolean updateAccount(long id, Account accountToUpdate);

	boolean deleteAccount(long id);

}