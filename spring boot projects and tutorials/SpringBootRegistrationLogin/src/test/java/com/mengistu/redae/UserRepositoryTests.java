package com.mengistu.redae;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.mengistu.redae.model.User;
import com.mengistu.redae.repositoryDAO.UserRepositoryDAO;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	/*
	 * Note:
	 * "TestEntityManager" is alternative to "EntityManager" for use in JPA tests
	 * 
	 * "EntityManager" an interface used to interact with the persistence context.
	 * 
	 * An EntityManager instance is associated with a persistence context. A
	 * persistence context is a set of entity instances in which for any persistent
	 * entity identity there is a unique entity instance. Within the persistence
	 * context, the entity instances and their life-cycle are managed.The
	 * EntityManager API is used to create and remove persistent entity instances, to
	 * find entities by their primary key, and to query over entities.
	 * 
	 * The set of entities that can be managed by a given EntityManager instance is
	 * defined by a persistence unit. A persistence unit defines the set of all
	 * classes that are related or grouped by the application, and which must
	 * be co-located in their mapping to a single database.
	 */
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepositoryDAO repo;
	
	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */
	
	// test methods
	@Test
	public void testCreateUser() {
		
		User user = new User();
		
		user.setEmail("mredae1@gmail.com");
		/*
		 * String encodedPassword = passwordEncoder.encode("men123");
		 * 
		 * When the password "men123" is encoded by the password encoder, the result is:
		 
		  		$2a$10$6WTbDFJdV8PHoZO7.eNakelQm8Zh9KlWG3ZMr8ki6mJ/3CabAtpnG
		  Therefore, use "men123" as a login password, but the encoded password will be saved in DB.
		 */
		user.setPassword("$2a$10$6WTbDFJdV8PHoZO7.eNakelQm8Zh9KlWG3ZMr8ki6mJ/3CabAtpnG");
	    user.setFirstName("Mengistu");
	    user.setLastName("Redae");
	    
		/*
		 * The JPA save() method: Saves a given entity. 
		 * Parameters:entity must not be null.
		 * Returns:the saved entity; and will never be null.
		 * Throws:IllegalArgumentException - in case the given entity is null.
		 */
	    User savedUser = repo.save(user);
	    	    
		/*
		 * The "EntityManager" find() method: searches ById
		 * Parameters: the entity class and primaryKey of the entity 
		 * Returns:the found entity or null if the entity does not exist
		 */
	    User existUser = entityManager.find(User.class, savedUser.getId());
	    
		/*
		 * assertion statement. It is more readable and more fluent than using
		 * traditional JUnit’s assertion methods.
		 */	    
	    assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
	}
}
