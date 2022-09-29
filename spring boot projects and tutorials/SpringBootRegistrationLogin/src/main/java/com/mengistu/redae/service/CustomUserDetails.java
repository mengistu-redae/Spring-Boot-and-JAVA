package com.mengistu.redae.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mengistu.redae.model.User;

/*
	To implement authentication (login) feature, we need to create a class of 
	subtype "UserDetails" (defined by Spring Security) to represent an authentication user 
	
	Spring Security will invoke methods in this class during the authentication process.
*/
public class CustomUserDetails implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	//constructor
	public CustomUserDetails(User user) {
        this.user = user;
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		
		//b/c we made the email column in the DB unique which enable us to use it as a user name
		return user.getEmail(); 
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return user.isEnabled();
	}
	
	public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }

}
