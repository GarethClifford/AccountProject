package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repo.AccountServiceDBImpl;
import com.qa.service.IAccountService;


@Path("/account")
public class AccountEndPoint {
	
	@Inject
	private IAccountService service;

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@Path("/findAnAccount/{id}")
	@GET
	@Produces({ "application/json" })
	public String findAnAccount(@PathParam("id") Long id) {
		return service.findAnAccount(id).getAccountNumber();
	} 
	
	@Path("/createAnAccount")
	@POST
	@Produces({ "application/json" })
	public String createAnAccount(String account) {
		return service.createAnAccount(account);
	}


	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return service.deleteAnAccount(id);
	}
	
	@Path("/updateAnAccount/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAnAccount(@PathParam("id") Long id, String acc) {
		return service.updateAnAccount(id, acc);
	}
	
	
	

	public void setService(IAccountService service) {
		this.service = service;
	}

}
