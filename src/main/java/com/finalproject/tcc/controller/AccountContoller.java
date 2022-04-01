package com.finalproject.tcc.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.finalproject.tcc.model.Account;
import com.finalproject.tcc.service.AccountService;

@RestController
@RequestMapping("api/accounts")
public class AccountContoller {

	private AccountService accountService;

	public AccountContoller(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@GetMapping
	public ResponseEntity<List<Account>> findAll() {
		List<Account> list = accountService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> findById(@PathVariable("id") Long id) {
		Account accountFind = accountService.findById(id);
		return ResponseEntity.ok(accountFind);
		
	}

	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account accountCreate = accountService.createAccount(account);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(accountCreate.getId()).toUri();	
		
		return ResponseEntity.created(location).body(accountCreate);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathVariable Long id) {
		account = accountService.updateAccount(account, id);
		return ResponseEntity.ok().body(account);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Account> deleteById(@PathVariable Long id){
		accountService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
