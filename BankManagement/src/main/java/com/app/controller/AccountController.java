package com.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.Account;
import com.app.service.AccountService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	//create the account 
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createAccount = service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
		
	}
	
	//get the details by the account Number
	@GetMapping("/{accountNumber}")
	public Account getAccountByAccounNumber( @PathVariable Long accountNumber) {
		Account account = service.getBankDetailsByAccountNumber(accountNumber);
		return account;
		
	}
	
	//getting the all of the details of account
	@GetMapping("/get-all")
	public List<Account> getAllAccountDetails(){
		List<Account> allAccountDetails = service.getAllAccountDetails();
		return allAccountDetails;
	}
	
	
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public Account depositAccount(@PathVariable Long accountNumber, @PathVariable Double amount) {
		Account account = service.depositAmount(accountNumber, amount);
		return account;	
	}

	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public Account withdrawAccount(@PathVariable Long accountNumber, @PathVariable Double amount) {
		Account account = service.withdrawAmount(accountNumber, amount);
		return account;
	}


	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber) {
		service .closeAccount(accountNumber);
		return ResponseEntity.status(HttpStatus.OK).body("Account is closed");
	}
}
