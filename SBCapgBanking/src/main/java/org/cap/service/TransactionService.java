package org.cap.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cap.dao.IAccountDao;
import org.cap.dao.ITransactionDao;
import org.cap.model.Account;
import org.cap.model.Transaction;
import org.cap.model.TransactionType;

@Service("transactionService")
public class TransactionService implements ITransactionService{

	@Autowired
	ITransactionDao transactionDao;
	
	@Autowired
	IAccountDao accountDao;
	
	@Override
	public boolean createTransaction(Transaction transaction) {
		if(transaction.getTransactionType().equals("withdrawal")
				|| transaction.getTransactionType().equals("fund transfer")) {
			IAccountService accountService = new AccountService();
			double balance = accountService.getCurrentBalanceOfAccount(transaction.getFromAccount());
			if(balance<transaction.getAmount()) {
				return false;
			}
		}
		transactionDao.save(transaction);
		return true;
	}

	@Override
	public List<Transaction> getAllTransactionsOfCustomer(int customerId) {
		List<Long> accountNumberList = accountDao.getAccountNumberByCustomerCustomerId(customerId);
		return transactionDao.getTransactionByFromAccountInOrToAccountIn(accountNumberList,accountNumberList);
	}

	@Override
	public List<Transaction> getAllTransactionsOfAccount(long accountNumber) {
		List<Long> list = new ArrayList<Long>();
		list.add(accountNumber);
		return transactionDao.getTransactionByFromAccountInOrToAccountIn(list,list);
	}

	@Override
	public List<Transaction> getAllTransactionsOfCustomerBetweenDates(int customerId, Date fromDate, Date toDate) {
		List<Long> accountNumberList = accountDao.getAccountNumberByCustomerCustomerId(customerId);
		List<Transaction> allList = transactionDao.getTransactionByFromAccountInOrToAccountIn(accountNumberList,accountNumberList);
		System.out.println("allList");
		System.out.println(allList);
		allList.removeIf(t -> (t.getTransactionDate().before(fromDate) || t.getTransactionDate().after(toDate)));
		return allList;
	}

}
