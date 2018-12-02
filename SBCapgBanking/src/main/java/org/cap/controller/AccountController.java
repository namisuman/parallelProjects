package org.cap.controller;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.model.LoginPojo;
import org.cap.model.Message;
import org.cap.service.IAccountService;
import org.cap.service.ILoginService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class AccountController {

	@Autowired
	private IAccountService accountService;
	
	@PostMapping(value = "/account/{customerId}")
	public ResponseEntity<Message> insertAccount(@RequestBody Account account,@PathVariable int customerId) {
		System.out.println("account add");
		
		Customer cBean = new Customer();
		cBean.setCustomerId(customerId);
		account.setCustomer(cBean);
		account.setOpeningDate(Date.from(Instant.now()));
		
		System.out.println(account);
		boolean s = accountService.addAccount(account);
		System.out.println(s);
		//CustomerBean customer = null;
		if (!s) {
			ResponseEntity<Message> responseEntity = new ResponseEntity<Message>(new Message("Account creation falied",false), HttpStatus.INTERNAL_SERVER_ERROR);
			return responseEntity;
		}
		ResponseEntity<Message> responseEntity = new ResponseEntity<Message>(new Message("Account created successfully",true), HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value = "/account/{customerId}")
	public ResponseEntity<List<Account>> getAccounts(@PathVariable int customerId) {
		System.out.println("account of cus "+customerId);
		List<Account> list = accountService.getAccountByCustomerCustomerId(customerId);
		System.out.println(list);
		if (list==null) {
			new ResponseEntity("No account found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Account>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/account/all")
	public ResponseEntity<List<Account>> getAllAccounts() {
		System.out.println("all accounts");
		List<Account> list = accountService.getAllAccounts();
		System.out.println(list);
		if (list==null) {
			new ResponseEntity("No account found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Account>>(list, HttpStatus.OK);
	}
	
}
