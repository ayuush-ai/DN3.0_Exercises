package com.example.bookstoreapi.controller;

public class CustomerController {

	
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
	    // Implementation to create a customer
	}
	
	@PostMapping("/register")
	public String registerCustomer(@ModelAttribute CustomerForm form) {
	    // Implementation to process form data
	}


}
