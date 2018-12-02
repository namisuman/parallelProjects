package org.cap.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cap.dao.IAccountDao;
import org.cap.dao.ITransactionDao;
import org.cap.model.Account;
import org.cap.model.Transaction;
import org.cap.model.TransactionType;

@Service("accountService")
public class AccountService implements IAccountService{

	@Autowired
	IAccountDao accountDao;
	
	@Override
	public boolean addAccount(Account account) {
		accountDao.save(account);
		return true;
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountDao.findAll();
	}

	@Override
	public List<Account> getAccountByCustomerCustomerId(int customerId) {
		return accountDao.getAccountByCustomerCustomerId(customerId);
	}

	@Override
	public List<Account> getAccountsOfOtherCustomers(int excludedCustomerId) {
		return accountDao.getAccountNotByCustomerCustomerId(excludedCustomerId);
	}

	@Override
	public Account getAccountFromAccountNumber(long accountId) {
		 Optional<Account> optional = accountDao.findById( (int) accountId);
		 if(optional.isPresent()) {
			 return optional.get();
		 }else {
			 return null;
		 }
	}

	@Override
	public double getCurrentBalanceOfAccount(Account account) {
		/*ITransactionDao transactionDao = new TransactionDaoImpl();
		Set<Transaction> transactions = transactionDao.getAllTransactionsOfAccount(account.getAccountNumber());
		double balance = account.getOpeningBalance();
		for(Transaction transaction:transactions) {
			if(transaction.getTransactionType()==TransactionType.DEPOSITE) {
				balance += transaction.getAmount();
			}else if(transaction.getTransactionType()==TransactionType.WITHDRAWAL){
				balance -= transaction.getAmount();
			}else if(transaction.getTransactionType()==TransactionType.FUND_TRANSFER){
				if(transaction.getFromAccount().getAccountNumber() == account.getAccountNumber()) {
					balance -= transaction.getAmount();
				}
				if(transaction.getToAccount().getAccountNumber() == account.getAccountNumber()){
					balance += transaction.getAmount();
				}
			}
		}
		return balance;*/
		return 5000;
	}
}
