package com.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Account;
import com.app.repo.AccountRepo;
import com.app.service.AccountService;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo repo;
	
	@Override
	public Account createAccount(Account account) {
		Account account_saved = repo.save(account);
		return account_saved;
	}

	@Override
	public Account getBankDetailsByAccountNumber(Long accountNumber) {
	    Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account account_found =account.get();
	    return account_found;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		List<Account>listOfAccounts = repo.findAll();
		return listOfAccounts;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not Present");
		}
		Account accountPresent = account.get();
		double totalBalance =accountPresent.getAccount_balance()+amount;
		accountPresent.setAccount_balance(totalBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not Present");
		}
		Account accountPresent = account.get();
		Double totalBalance = accountPresent.getAccount_balance()-amount;
		accountPresent.setAccount_balance(totalBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		getBankDetailsByAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
		
	}

}
