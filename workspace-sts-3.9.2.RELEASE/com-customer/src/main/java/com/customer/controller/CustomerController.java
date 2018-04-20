package com.customer.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.customer.model.Customer;
import com.customer.model.CustomerRepository;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customers")
	public List<Customer> retrieveAllCustomers() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customer retrieveCustomer(@PathVariable long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);

		if (!customerOptional.isPresent())
			try {
				throw new CustomerNotFoundException("id-" + id);
			} catch (CustomerNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return customerOptional.get();
	}
	
	@GetMapping("/customers/eligibility/{id}")
	public String retrieveEligibility(@PathVariable long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);

		if (!customerOptional.isPresent())
			try {
				throw new CustomerNotFoundException("id-" + id);
			} catch (CustomerNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return customerOptional.get().getEligibility();
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCustomer.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Customer customer, @PathVariable long id) {

		Optional<Customer> customerOptional = customerRepository.findById(id);

		if (!customerOptional.isPresent())
			return ResponseEntity.notFound().build();

		customer.setId(id);
		
		customerRepository.save(customer);

		return ResponseEntity.noContent().build();
	}
	
}