package org.cap.controller;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.cap.model.Transaction;
import org.cap.service.IAccountService;
import org.cap.service.ILoginService;
import org.cap.service.ITransactionService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class TransactionController {

	@Autowired
	private ITransactionService transactionService;
	
	@PostMapping(value = "/transaction")
	public ResponseEntity<Message> insertAccount(@RequestBody Transaction transaction) {
		System.out.println("transaction add");
		
		transaction.setTransactionDate(Date.from(Instant.now()));
		//transaction.setTransactionDate(new Date(2018-1900,10-1,1));
		
		System.out.println(transaction);
		boolean s = transactionService.createTransaction(transaction);
		System.out.println(s);
		//CustomerBean customer = null;
		if (!s) {
			ResponseEntity<Message> responseEntity = new ResponseEntity<Message>(new Message("Transaction falied",false), HttpStatus.INTERNAL_SERVER_ERROR);
			return responseEntity;
		}
		ResponseEntity<Message> responseEntity = new ResponseEntity<Message>(new Message("Transaction successful",true), HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value = "/transaction/customer/{customerId}")
	public ResponseEntity<List<Transaction>> getAccountsOfCustomer(@PathVariable Integer customerId) {
		System.out.println("Transaction of cus "+customerId);
		List<Transaction> list = transactionService.getAllTransactionsOfCustomer(customerId);
		System.out.println(list);
		if (list==null) {
			new ResponseEntity("No transaction found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/transaction/customer/{customerId}/date/{fromDate}/{toDate}")
	public ResponseEntity<List<Transaction>> getAccountsOfCustomerByDate(
			@PathVariable Integer customerId,
			@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,
			@PathVariable  @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) {
		System.out.println("Transaction of cus "+customerId+"btw "+fromDate+" and "+toDate);
		List<Transaction> list = transactionService.getAllTransactionsOfCustomerBetweenDates(customerId,fromDate,toDate);
		System.out.println(list);
		if (list==null) {
			new ResponseEntity("No transaction found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/transaction/account/{accountId}")
	public ResponseEntity<List<Transaction>> getTransactionsOfAccount(@PathVariable Integer accountId) {
		System.out.println("Transaction of accountId  "+accountId);
		List<Transaction> list = transactionService.getAllTransactionsOfAccount(accountId);
		System.out.println(list);
		if (list==null) {
			new ResponseEntity("No transaction found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);
	}
}
