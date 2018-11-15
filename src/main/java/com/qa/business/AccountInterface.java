package com.qa.business;

public interface AccountInterface {

	String getAllAccounts();

	String addAccount(String account);

	String updateAccount(long id, String account);

	String deleteAccount(long id);
	
}
