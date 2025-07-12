package com.app.service;

import java.util.List;

import com.app.entities.Account;


public interface AccountService {

	public Account createAccount(Account account);
	public Account getBankDetailsByAccountNumber(Long account);
	public List<Account> getAllAccountDetails();
	public Account depositAmount(Long accountNumber, Double amount);
	public Account withdrawAmount(Long accountNumber,Double amount);
	public void closeAccount(Long accountNumber);
	

}
