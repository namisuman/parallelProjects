package org.cap.service;

import java.util.List;
import java.util.Set;

import org.cap.model.Account;

public interface IAccountService {

	public boolean addAccount(Account account);
	public List<Account> getAllAccounts();
	public List<Account> getAccountByCustomerCustomerId(int customerId);
	public List<Account> getAccountsOfOtherCustomers(int excludedCustomerId);

	public Account getAccountFromAccountNumber(long accountNumber);
	public double getCurrentBalanceOfAccount(Account account);
}
