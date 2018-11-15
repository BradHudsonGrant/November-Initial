package com.qa.repository;

public interface AccountRepo {

	String getAllAccounts();

	String createAccount(String account);

	String updateAccount(long id, String accountToUpdate);

	String deleteAccount(long id);

}