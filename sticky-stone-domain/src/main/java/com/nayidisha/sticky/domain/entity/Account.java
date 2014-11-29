package com.nayidisha.sticky.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.Identifiable;

@Entity
@Table (name = "account")
public class Account implements Identifiable<Long>, Serializable{

	private static final long serialVersionUID = 2371077079234718620L;
	

	
	private Long id;
	private String name;
	private AccountType accountType;
	
	public Account(Long id) {
		this.id = id;
	}
	
	public Account(Long id, String name, AccountType accountType) {
		this.id = id;
		this.name = name;
		this.accountType = accountType;
	}
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id")
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
