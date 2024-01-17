package com.mengistu.redae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mengistu.redae.model.User;
import com.mengistu.redae.repositoryDAO.UserRepositoryDAO;

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

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepositoryDAO userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*
		 * we made the email column unique in the users table, so we define the
		 * findByEmail() method that returns a single User object based on email (no two
		 * users having the same email).
		 */
		User user = userRepo.findByEmail(username);
		
		if(user == null)
			throw new UsernameNotFoundException("User not found!");
		
		return new CustomUserDetails(user);
	}

}
