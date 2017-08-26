package com.techelevator;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {

	private Long id;
	
	@NotBlank(message="Email address is a required field")
	@Email(message="Email must be a valid email address")
	private String email;
	
	@NotBlank(message="Username is a required field")
	@Size(max=20, message="Username must be 20 characters or less")
	private String username;
	
	@NotBlank(message="Password is a required field")
	@Size(min=8, message="Password must be at least 8 characters")
	private String password;
	
	@NotBlank(message="Confirm Password is a required field")
	private String confirmPassword;
	
	private boolean passwordMatching; 
	@AssertTrue(message="Passwords must match")
	public boolean isPasswordMatching() {
		if(password != null) {
			return password.equals(confirmPassword);
		} else {
			return false;
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setPasswordMatching(boolean passwordMatching) {
		this.passwordMatching = passwordMatching;
	}
	

    
}
