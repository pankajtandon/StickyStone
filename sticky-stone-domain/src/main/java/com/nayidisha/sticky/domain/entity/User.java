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
	
	private final Long id;
    private final String name;
    private String password;
    private String title;
	private Date startDate;
	
	@JsonIgnore
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (nullable = true, name = "account_id_fkey") 
	private Account account;
    
    public User (Long id, String name){
    	this.id = id;
    	this.name = name;
    }

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@Column (name = "id", unique = true, nullable = false)    
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
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
    
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(5, 101)
			.append(this.id)
			.append(this.name)
			.append(this.title)
			.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		boolean boo = false;
		if (other instanceof User){
			User o = (User)other;
		    boo =  new EqualsBuilder()
		    .append(o.name, this.name)
		    .append(o.id, this.id)
		    .isEquals();
		}
		return boo;
	}
    
}
