package org.cap.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.cap.model.Transaction;

public interface ITransactionService {

	public List<Transaction> getAllTransactionsOfCustomer(int customerId);
	public List<Transaction> getAllTransactionsOfCustomerBetweenDates(int customerId,Date fromDate,Date toDate);
	public List<Transaction> getAllTransactionsOfAccount(long accountNumber);
	public boolean createTransaction(Transaction transaction);
	
	//public List<Transaction> getTransactionByDate(Date fromDate,Date toDate);
	/*public List<Transaction> getTransactionByAccountAndDate(
			List<Long> fromAccountNumber,List<Long> toAccountNumber,Date fromDate,Date toDate);
	
	public List<Transaction> getTransactionByAccountList(
			List<Long> fromAccountNumber,List<Long> toAccountNumber);
	*/
}
