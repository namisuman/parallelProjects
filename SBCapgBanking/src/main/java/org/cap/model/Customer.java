package org.cap.model;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private int customerId;
	private String firstName;
	private String lastName;
	@JsonFormat(pattern="dd-MMM-yyyy")
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	private Date dateOfBirth;
	private String emailId;
	private String mobile;
	private String customerPwd;
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	
	public Customer() {}


	public Customer(int customerId, String firstName, String lastName, Date dateOfBirth, String emailId, String mobile,
			String customerPwd, Address address) {
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


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
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


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId + ", mobile=" + mobile + ", customerPwd="
				+ customerPwd + ", address=" + address + "]";
	}
	
	
}
