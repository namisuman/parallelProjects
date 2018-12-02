package org.cap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.cap.model.Customer;
import org.cap.service.ILoginService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class LoginController {

	@Autowired
	private ILoginService loginService;

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<Customer> insertPilot(@RequestBody Customer customer) {
		Customer customerFull = loginService.isValidLogin(customer);
		//CustomerBean customer = null;
		if (customerFull == null) {
			return new ResponseEntity("Login failed", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customerFull, HttpStatus.OK);
	}
}
