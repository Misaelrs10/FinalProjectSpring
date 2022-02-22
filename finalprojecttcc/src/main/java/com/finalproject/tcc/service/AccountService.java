package com.finalproject.tcc.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.finalproject.tcc.repository.AccountRepository;
import com.finalproject.tcc.controller.handle.ResourceNotFound;
import com.finalproject.tcc.model.Account;

@Service
public class AccountService {
	
	private AccountRepository accountRepository;
	
	public AccountService (AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public Page<Account> findAll(Pageable pageable){
		Page<Account> list = accountRepository.findAll(pageable);
		return list;
	}
	
	public Account getById(Long id) {
		Optional<Account> account = accountRepository.findById(id);
		Account a = account.orElseThrow(() -> new ResourceNotFound("Account not found!"));
		return a;
	}
	/*
	public Account create (Account account) {
		try {
			Account a = new Account();
			a.setNameOwner(a.getNameOwner());
			a.setAgencyCode(a.getAgencyCode());
			
			accountRepository.save(a);
			return a;
		}catch(DataIntegrityViolationException e) {
			throw new AccountException("Account: "+ account.getDigitVerification()+" já existe na base da dados");
		}		
	}*/
	
}
