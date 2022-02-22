package com.finalproject.tcc.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finalproject.tcc.model.Account;
import com.finalproject.tcc.service.AccountService;

@RestController
@RequestMapping("api/accounts")
public class AccountContoller{
	
	private final AccountService accountService;
	
	public AccountContoller(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping
	public ResponseEntity<Page<Account>> getAll(Pageable pageable){
		 Page<Account> listAccount = accountService.findAll(pageable);		
		return ResponseEntity.ok().body(listAccount);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getById(@PathVariable Long id) {
		Account account = accountService.getById(id);
		return ResponseEntity.ok(account);
	}
	/*
	@PostMapping
	public ResponseEntity<Account> create(@RequestBody Account account){
		Account a = accountService.create(account);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(p.getId()).toUri();	
		
		return ResponseEntity.created(location).body(p);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Account> update(@RequestBody Account account, @PathVariable Long id){
		pessoa = pessoaService.update(account, id);
		return ResponseEntity.ok().body(account);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Account> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}*/
	
}
