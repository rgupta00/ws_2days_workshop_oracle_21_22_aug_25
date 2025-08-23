package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private AccountRepo accountRepo;

	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public List<Account> getAll() {
		return accountRepo.findAll();
	}

	@Override
	public Account getById(int accId) {
		return accountRepo.findById(accId)
				.orElseThrow(() -> new BankAccountNotFoundException("account with id " + accId + " is not found"));
	}

	@Override
	public void transfer(int fromAccId, int toAccId, BigDecimal balance) {
		Account fromAcc = getById(fromAccId);
		Account toAcc = getById(toAccId);

		fromAcc.setBalance(fromAcc.getBalance().subtract(balance));
		toAcc.setBalance(toAcc.getBalance().add(balance));

		accountRepo.save(fromAcc);
		accountRepo.save(toAcc);

	}

	@Override
	public void deposit(int accId, BigDecimal balance) {
		Account acc = getById(accId);
		acc.setBalance(acc.getBalance().add(balance));
	}

	@Override
	public void withdraw(int accId, BigDecimal balance) {
		Account acc = getById(accId);
		acc.setBalance(acc.getBalance().subtract(balance));

	}

}
