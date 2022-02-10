package com.example.demo.shared.dto;

import java.io.Serializable;

public class UserDto implements Serializable{

	private static final long serialVersionUID = -5635731333184165900L;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String encryptedPassword;
	private String emailverifactionToken;
	private String emailverficationStatus;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public String getEmailverifactionToken() {
		return emailverifactionToken;
	}
	public void setEmailverifactionToken(String emailverifactionToken) {
		this.emailverifactionToken = emailverifactionToken;
	}
	public String getEmailverficationStatus() {
		return emailverficationStatus;
	}
	public void setEmailverficationStatus(String emailverficationStatus) {
		this.emailverficationStatus = emailverficationStatus;
	}
}
