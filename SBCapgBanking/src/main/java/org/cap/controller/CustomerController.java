package org.cap.controller;

import java.util.List;

import org.cap.model.Customer;
import org.cap.model.LoginPojo;
import org.cap.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private IService service;
	
	
	//check login credentials
	@RequestMapping("/validateLogin")
	public String validateLogin(ModelMap map,
			@ModelAttribute("login") LoginPojo loginPojo) {
		List<Customer> customers= service.getAllCustomers();
		
		if(service.isValidLogin(loginPojo)) {
			map.addAttribute("butLabel","update");
			map.addAttribute("customer", new Customer());
			map.addAttribute("customers", customers);
			
			return "register";
		}
		
		return "redirect:/";
		
	} 
	
	//register customer
	@PostMapping(value="/customers")
	public ResponseEntity<List<Customer>> registerCustomer(@RequestBody Customer customer)
	{
		List<Customer> customers=service.registerCustomer(customer);
		if(customers.isEmpty())
		{
			return new ResponseEntity("Insertion Failed",HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
		
	}
	
	//get list of customers
	@GetMapping(value="/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers= service.getAllCustomers();
		
		if(customers.isEmpty())
			return new ResponseEntity("Sorry! Customer list not available!", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	//update customer details
	@PutMapping(value="/customers")
	public ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer){
		List<Customer> customers=service.updateCustomer(customer);
		if(customers.isEmpty())
		{
			return new ResponseEntity("Updation Failed",HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
		
	}
	
	
	//delete customer
	@DeleteMapping(value="/customers/{custId}")
	public ResponseEntity<List<Customer>>deletCustomer(
			@PathVariable("custId")Integer custId){
		List<Customer> customers= service.deleteCustomer(custId);
		
		if(customers==null)
			return new ResponseEntity
					("Sorry! Customer Id not available!", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	//get details of particular customer
	@GetMapping(value="/customers/{custId}")
	public ResponseEntity<Customer> findCustomers(
			@PathVariable("custId")Integer custId){
		Customer customer= service.findCustomer(custId);
		
		if(customer==null)
			return new ResponseEntity
					("Sorry! Customer ID does not exists!", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	
}
