package org.cap.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private long accountNumber;
	private String accountType;
	@JsonFormat(pattern="dd-MMM-yyyy")
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	private Date openingDate;
	private double openingBalance;
	private String description;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	public Account() {
		
	}

	public Account(long accountNumber, String accountType, Date openingDate, double openingBalance, String description,
			Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.openingDate = openingDate;
		this.openingBalance = openingBalance;
		this.description = description;
		this.customer = customer;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", openingDate="
				+ openingDate + ", openingBalance=" + openingBalance + ", description=" + description + ", customer="
				+ customer + "]";
	}
	
	

}
