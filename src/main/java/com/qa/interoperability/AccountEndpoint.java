package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.AccountInterface;

@Path("/account")
public class AccountEndpoint {

	@Inject
	private AccountInterface accountInter;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return accountInter.getAllAccounts();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public String addAccount(String account) {
		return accountInter.addAccount(account);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String account) {
		return accountInter.updateAccount(id, account);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return accountInter.deleteAccount(id);

	}

}
