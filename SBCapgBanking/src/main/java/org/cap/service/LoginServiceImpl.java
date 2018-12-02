package org.cap.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cap.dao.ILoginDao;
import org.cap.model.Customer;

@Service("loginService")
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private ILoginDao loginDao;

	@Override
	public Customer isValidLogin(Customer customerBean) {
		String email = customerBean.getEmailId();
		String password = customerBean.getCustomerPwd();
		System.out.println("email "+email);
		System.out.println("password " + password);
		Customer customerBean2 = getCustomerByEmailIdAndCustomerPwd(email,password);
		System.out.println("customerBean2");
		System.out.println(customerBean2);
		return customerBean2;
	}

	@Override
	public Customer getCustomerByEmailIdAndCustomerPwd(String email, String password) {
		return loginDao.getCustomerByEmailIdAndCustomerPwd(email,password);
	}

	
	
}
