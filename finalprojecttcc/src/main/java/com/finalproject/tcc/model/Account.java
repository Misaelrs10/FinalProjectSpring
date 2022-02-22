package com.finalproject.tcc.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_account")
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="nameOwner")
	private String nameOwner;

	@Column(name="agencyCode")
	private String agencyCode;

	@Column(name="numberAccount")
	private String numberAccount;

	@Column(name="digitVerification")
	private String digitVerification;

	@Column(name="registerId")
	private String registerId;
	
	public String getNameOwner() {
		return nameOwner;
	}
	
	public Account () {
		
	}
	
	public Account(Long id, String nameOwner, String agencyCode, String numberAccount, String digitVerification,
			String registerId) {
		super();
		this.id = id;
		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.numberAccount = numberAccount;
		this.digitVerification = digitVerification;
		this.registerId = registerId;
	}

	//@Size(min = 1, max = 50)
	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	public String getAgencyCode() {
		return agencyCode;
	}
	
	//@Size(min = 1, max = 4)
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getNumberAccount() {
		return numberAccount;
	}
	
	//@Size(min = 1, max = 8)
	public void setNumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}

	public String getDigitVerification() {
		return digitVerification;
	}
	
	//@Size(min = 1, max = 3)
	public void setDigitVerification(String digitVerification) {
		this.digitVerification = digitVerification;
	}

	public String getRegisterId() {
		return registerId;
	}
	
	//@Size(min = 1, max = 20)
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

}
