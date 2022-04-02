package com.finalproject.tcc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nameOwner", length = 40)
	@Size(min = 1, max = 40)
	private String nameOwner;

	@Column(name = "agencyCode", length = 4)
	@Size(min = 1, max = 4)
	private String agencyCode;

	@Column(name = "numberAccount", length = 8)
	@Size(min = 1, max = 8)
	private String numberAccount;

	@Column(name = "digitVerification", length = 3)
	@Size(min = 1, max = 3)
	private String digitVerification;

	@Column(name = "registerId", length = 20)
	@Size(min = 1, max = 20)
	private String registerId;

}
