package com.mengistu.redae.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	
	@Column(nullable = false, length = 64)
	private String password;
	
	@Column(name="first_name", nullable = false, length = 25)
	private String firstName;
	
	@Column(name="last_name", nullable = false, length = 25)
	private String lastName;
	
	/*
	 * "verificationCode" stores a random, unique String which is generated in the registration
	 * process and will be used in the verification process.
	 */	
	@Column(name ="verification_code", length = 64)
	private String verificationCode;
	
	/*
	 * Once registered, the enabled status of a user is false (disabled) so the user
	 * can’t login if he has not activated account by checking email and click on
	 * the verification link embedded in the email.
	 */
	private boolean enabled;
	
	public Long getId() {
		return id;
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

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }
	
}
