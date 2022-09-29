package com.mengistu.redae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mengistu.redae.model.User;
import com.mengistu.redae.repositoryDAO.UserRepositoryDAO;

/*
	Spring Security will invoke methods in "CustomUserDetails" class during the 
	authentication process.	
	
	And hence, to tell Spring Security how to look up the user information, we need to code 
	another class that implements the "UserDetailsService" interface
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
