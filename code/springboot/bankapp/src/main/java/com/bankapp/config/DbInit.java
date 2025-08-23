package com.bankapp.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.bankapp.entities.Account;
import com.bankapp.repo.AccountRepo;
@Configuration
public class DbInit implements CommandLineRunner{

	@Autowired
	private AccountRepo accountRepo;
	
	@Override
	public void run(String... args) throws Exception {
		accountRepo.save(new Account("raj", BigDecimal.valueOf(4000)));
		accountRepo.save(new Account("sumit", BigDecimal.valueOf(4000)));
	}

}
