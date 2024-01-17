package com.mengistu.redae.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mengistu.redae.model.User;

/*
	To implement authentication (login) feature, we need to create a classes of 
	subtypes of the interfaces "UserDetails" and "UserDetailsService" (defined by Spring Security) 
	to represent an user authentication.
	
	Spring Security will invoke methods in this class during the authentication process.
	
"UserDetailsService" interface:
    - Purpose: The UserDetailsService interface is responsible for retrieving user details from 
      a data store (such as a database or an in-memory data structure) based on a username. 
      It is a part of the Spring Security framework and is used to load user-specific data during 
      the authentication process.
    - Methods: The primary method in UserDetailsService is loadUserByUsername(String username), 
      which returns a UserDetails object containing information about the user, including the 
      user's username, password, and granted authorities.

"UserDetails" interface:
    - Purpose: The UserDetails interface represents the core user information returned by 
      the UserDetailsService. It contains essential information about a user, such as the 
      username, password (or a password-encoded representation), and a collection of 
      granted authorities (roles).
    - Methods: The UserDetails interface defines several methods, including getUsername(), 
      getPassword(), getAuthorities(), and others.
      
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
