package com.example.rest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.Models.Customer;
import com.example.rest.Repo.CustomerRepo;

import java.util.List;


@RestController
public class ApiControllers {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@GetMapping(value="/")
	public String getPage() {
		return "Welcome";
	}
	
	@GetMapping(value="/customers")
	public List<Customer> getCustomers() {
		return customerRepo.findAll();
	}
	
	@PostMapping(value = "save")
	public String createCustomer(@RequestBody Customer customer) {
		customerRepo.save(customer);
		return "Saved ... ";	
	}
	
	@PutMapping(value= "/update/{id}")
	public String updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
		
		//take care if the returned optional object is empty
		Customer updatedCustomer = customerRepo.findById(id).get();
		
		updatedCustomer.setName(customer.getName());
		updatedCustomer.setEmail(customer.getEmail());
		updatedCustomer.setPhone(customer.getPhone());
		updatedCustomer.setCity_region(customer.getCity_region());
		updatedCustomer.setCc_number(customer.getCc_number());
		
		customerRepo.save(updatedCustomer);
		
		return "Updated ... ";
	}
	
	@DeleteMapping(value = "delete/{id}")
	public String deleteCustomer(@PathVariable long id) {
		//take care if the returned optional object is empty
		Customer deleteCustomer = customerRepo.findById(id).get();
		
		customerRepo.delete(deleteCustomer);
		return "Customer deleted with id: " + id;
	}
}
