package org.cap.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.cap.model.Account;
import org.cap.model.Customer;

@Repository("accountDao")
@Transactional
public interface IAccountDao  extends JpaRepository<Account,Integer>{

	//public boolean addAccount(Account account);
	//public Set<Account> getAccountsOfCustomer(long customerId);
	//public Set<Account> getAccountsOfOtherCustomers(long excludedCustomerId);
	//public Account getAccountFromAccountId(long accountId);
	
	public List<Account> getAccountByCustomerCustomerId(int customerId);
	public List<Long> getAccountNumberByCustomerCustomerId(int customerId);
	public List<Account> getAccountNotByCustomerCustomerId(int customerId);
}
