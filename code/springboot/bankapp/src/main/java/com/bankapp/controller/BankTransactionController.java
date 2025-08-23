package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.TransferDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping(path="accountapp/api")
public class BankTransactionController {
	
	private AccountService accountService;
	
	@Autowired
	public BankTransactionController(AccountService accountService) {
		this.accountService = accountService;
	}

	//get all
	@GetMapping(path="accounts")
	public List<Account> getAll(){
		return accountService.getAll();
	}
	
	//get by id
	
	//transfer
	@PostMapping(path="transfer")
	public String transfer(@RequestBody  TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccId(),
				transferDto.getToAccId(), transferDto.getAmount());
		
		return "fund is transferred successfully";
	}
	
	//deposit
	
	//withdraw
	

}
