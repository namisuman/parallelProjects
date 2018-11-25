package org.cap.model;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private int customerId;
	private String firstName;
	private String lastName;
	@JsonFormat(pattern="dd-MMM-yyyy")
	private LocalDate dateOfBirth;
	private String emailId;
	private String mobile;
	private String customerPwd;
	
	private Address address;
	
	private List<Account> accounts;
	
	public Customer() {}
	
	public Customer(int customerId, String firstName, String lastName, LocalDate dateOfBirth, String emailId,
			String mobile, String customerPwd, Address address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.mobile = mobile;
		this.customerPwd = customerPwd;
		this.address = address;
	}
	
	
	public Customer(int customerId, String firstName, String lastName, LocalDate dateOfBirth, String emailId,
			String mobile, String customerPwd, Address address, List<Account> accounts) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.mobile = mobile;
		this.customerPwd = customerPwd;
		this.address = address;
		this.accounts = accounts;
	}


	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCustomerPwd() {
		return customerPwd;
	}
	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId + ", mobile=" + mobile + ", customerPwd="
				+ customerPwd + ", address=" + address + ", accounts=" + accounts + "]";
	}
	
	
}
