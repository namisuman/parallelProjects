package org.cap.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue
	private int transactionID;
	@JsonFormat(pattern="dd-MMM-yyyy")
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date transactionDate;
	
	private double amount;
	private String description;
	private String transactionType;
	@OneToOne
	private Account fromAccount;
	@OneToOne
	private Account toAccount;
	
	public Transaction() {}
	
	public Transaction(int transactionID, Date transactionDate, double amount, String description,
			String transactionType, Account fromAccount, Account toAccount) {
		super();
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.description = description;
		this.transactionType = transactionType;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
	}


	public int getTransactionID() {
		return transactionID;
	}
	
	
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", transactionDate=" + transactionDate + ", amount="
				+ amount + ", description=" + description + ", transactionType=" + transactionType + ", fromAccount="
				+ fromAccount + ", toAccount=" + toAccount + "]";
	}
	
	
	
	
	

}
