package com.finalproject.tcc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalproject.tcc.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Optional<Account> findById(Long id);
	
}