package com.example.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.Models.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{

}
