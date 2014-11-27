package com.nayidisha.sticky.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.hateoas.Identifiable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "user")
public class User implements Identifiable<Long>, Serializable{

	private static final long serialVersionUID = 1364326568830699067L;
	
	private Long id;
	private String userId;
    private String name;
    private String password;
    private String title;
	private Date startDate;

    
	protected User() {
		//for JPA
	}
    public User (String userId, String name){
    	this.userId = userId;
    	this.name = name;
    }
    
    public User (Long id, String userId, String name){
    	this.id = id;
    	this.userId = userId;
    	this.name = name;
    }
	
	@JsonIgnore
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (nullable = true, name = "account_id_fkey") 
	private Account account;
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column (name = "id")    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public String getUserId() {
		return userId;
	}    

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(5, 101)
			.append(this.id)
			.append(this.userId)
			.append(this.name)
			.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		boolean boo = false;
		if (other instanceof User){
			User o = (User)other;
		    boo =  new EqualsBuilder()
		    .append(o.userId, this.userId)
		    .isEquals();
		}
		return boo;
	}


    
}
