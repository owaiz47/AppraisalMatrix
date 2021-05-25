package com.appraisal.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "user_table")
public class User extends AbstractPersistentObject implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(unique = true, nullable = false, length = 50)
	private String username;
	
	@Column(unique = true, nullable = false, length = 225, updatable = false)
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length = 225)
	private String password;
	
	@Column(nullable = false, length = 225)
	private String fullname;
	
	@Column(nullable= true, length = 225)
	private String dp;
	
	@Column(nullable = false)
	private boolean admin = false;
	
	@PostLoad
	public void fillTransients() {
		
	}

	public User(String username, String email, String password, String fullname, String dp, boolean admin) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.dp = dp;
		this.admin = admin;
	}

	public User() {
	}

	public User(Long id, Date createdOn, Date lastModifiedOn) {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDp() {
		return dp;
	}

	public void setDp(String dp) {
		this.dp = dp;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	

	
}
