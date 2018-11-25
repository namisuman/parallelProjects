package org.cap.service;

import java.util.List;

import org.cap.model.Customer;
import org.cap.model.LoginPojo;

public interface IService {

	boolean isValidLogin(LoginPojo loginPojo);

	List<Customer> getAllCustomers();

	List<Customer> createCustomer(Customer customer);

	List<Customer> registerCustomer(Customer customer);

	List<Customer> updateCustomer(Customer customer);

	List<Customer> deleteCustomer(Integer custId);

	Customer findCustomer(Integer custId);

}
