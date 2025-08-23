package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import com.bankapp.entities.Account;

public interface AccountService {
	
	public List<Account> getAll();
	public Account getById(int accId);
	
	public void transfer(int fromAccId, int toAccId, BigDecimal balance);
	
	public void deposit(int accId,  BigDecimal balance);
	public void withdraw(int accId,  BigDecimal balance);
	
	
	
	
}
