package com.finalproject.tcc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalproject.tcc.model.Account;
import com.finalproject.tcc.repository.AccountRepository;
import com.finalproject.tcc.service.exceptions.ResourceNotFound;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	
	public AccountService(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	public List<Account> findAll() {
		   List<Account> list = accountRepository.findAll();
		return list;
	}
	
	public Account findById(Long id) {
		Optional<Account> account = accountRepository.findById(id);
		try{
			return account.get();
		}catch(EmptyResultDataAccessException e){
			throw new ResourceNotFound("Id: " + id + "not found!");
		}
	}
	
	public Account createAccount(Account account) {
		try {
			Account saveAccount = new Account();
			saveAccount.setNameOwner(account.getNameOwner());
			saveAccount.setAgencyCode(account.getAgencyCode());
			saveAccount.setNumberAccount(account.getNumberAccount());
			saveAccount.setDigitVerification(account.getDigitVerification());
			saveAccount.setRegisterId(account.getRegisterId());
			accountRepository.save(saveAccount);
			return saveAccount;
		}catch(DataIntegrityViolationException e) {
			throw new ResourceNotFound("Account: "+ account.getNameOwner()+" already exists!");
		}
	}
				
	@Transactional
	public void deleteById(Long id) {
		try{
			accountRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFound("Id: " + id + " not found!");
		}
	}
	
	@Transactional
	public Account updateAccount(Account account, Long id) {
		try {
			Optional<Account> updateAccount = accountRepository.findById(id);
			updateAccount.get().setNameOwner(account.getNameOwner());
			updateAccount.get().setAgencyCode(account.getAgencyCode());
			updateAccount.get().setNumberAccount(account.getNumberAccount());
			updateAccount.get().setDigitVerification(account.getDigitVerification());
			updateAccount.get().setRegisterId(account.getRegisterId());
			return accountRepository.save(updateAccount.get());
		}catch(EmptyResultDataAccessException e ) {
			throw new ResourceNotFound("Id: "+ id +" not found!");
		}
	}

}
