package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MySqlConnectionApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(MySqlConnectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//data entry
//		INSERT INTO customer (`name`, email, phone, address, city_region, cc_number) VALUES ('Charlie Pace', 'c.pace@mailinator.com', '844-134-3777', '45 Autofcase Ouvonstaut', 'PG', '342392325479721');
//		INSERT INTO customer (`name`, email, phone, address, city_region, cc_number) VALUES ('MC Hammer', 'hammer@mailinator.com', '833-045-6368', 'Ruskacvotak 11', 'PG', '378168419808042');
//		INSERT INTO customer (`name`, email, phone, address, city_region, cc_number) VALUES ('Karel Gott', 'gott@mailinator.com', '855-837-2290', '83/12/45 Kosteln', 'PG', '370126117019757');
		String sql = "INSERT INTO customer (`name`, email, phone, address, city_region, cc_number) "
				+ "VALUES (?, ?, ?,?,?,?)";
		
		int result = jdbcTemplate.update(sql,"Charlie Pace", "c.pace@mailinator.com", "844-134-3777", "45 Autofcase Ouvonstaut", "PG", "342392325479721");

		if(result > 0) {
			System.out.println("A new row has been inserted!");
		}
		
		
	}

}
