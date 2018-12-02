package org.cap.service;

import org.cap.model.Customer;
import org.cap.model.LoginPojo;

public interface ILoginService {

	public Customer isValidLogin(Customer customer);
	public Customer getCustomerByEmailIdAndCustomerPwd(String email,String password);
}
