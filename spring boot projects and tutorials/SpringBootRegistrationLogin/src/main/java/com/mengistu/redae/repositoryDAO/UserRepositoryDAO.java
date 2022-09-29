package com.mengistu.redae.repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mengistu.redae.model.User;

@Repository
public interface UserRepositoryDAO extends JpaRepository<User, Long>{

	/*
	 * we made the email column unique in the users table, so we define the
	 * findByEmail() method that returns a single User object based on email (no two
	 * users having the same email).
	 */
	//@Query("FROM User u WHERE u.email = ?1")
	@Query("SELECT u FROM User u WHERE u.email = ?1") 
    public User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
    public User findByVerificationCode(String code);
}
