package com.finalproject.tcc.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nameOwner;
	private String agencyCode;
	private String numberAccount;
	private String digitVerification;
	private String registerId;
	
}
