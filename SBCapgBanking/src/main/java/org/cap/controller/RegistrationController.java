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
import org.cap.model.LoginPojo;
import org.cap.model.Message;
import org.cap.service.ILoginService;
import org.cap.service.IRegisterService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class RegistrationController {

	@Autowired
	private IRegisterService registerService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<Message> insertPilot(@RequestBody Customer customer) {
		System.out.println("add customer");
		System.out.println(customer);
		
		registerService.registerCustomer(customer);
		if (customer == null) {
			return new ResponseEntity(new Message("register failed",false), HttpStatus.NOT_FOUND);
		}
		ResponseEntity<Message> responseEntity = new ResponseEntity<Message>(new Message("success",true), HttpStatus.OK);
		System.out.println("re");
		System.out.println(responseEntity);
		return responseEntity;
	}
}
