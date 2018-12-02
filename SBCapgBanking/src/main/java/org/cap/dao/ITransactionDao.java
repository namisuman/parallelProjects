package org.cap.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.cap.model.Transaction;

@Repository("transactionDao")
@Transactional
public interface ITransactionDao extends JpaRepository<Transaction,Long>{

	//public List<Transaction> getAllTransactionsOfCustomer(long customerId);
	//public List<Transaction> getAllTransactionsOfCustomerInDateRange(long customerId,LocalDate fromDate,LocalDate toDate);
	//public List<Transaction> getAllTransactionsOfAccount(long accountNumber);
	//public boolean createTransaction(Transaction transaction);
	
	/*@Query("from Transaction where transactionDate between :fromDate and :toDate"
			+ "and (fromAccount.accountNumber in "
			+ "(accountNumber from Account where customer.customerId=:customerId) "
			+ "or toAccount.accountNumber in "
			+ "(accountNumber from Account where customer.customerId=:customerId))")
	public List<Transaction> getTransactionByDateAndAccount(
			Date fromDate,Date toDate,Long customerId);*/
	
	
	public List<Transaction> getTransactionByFromAccountInOrToAccountIn(
			List<Long> fromAccountNumber,List<Long> toAccountNumber);
//	@Query("from Transaction where transactionDate between :fromDate and :toDate")
//	public List<Transaction> getTransactionByDate(Date fromDate,Date toDate);
}
