package org.cap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cap.dao.IRegisterDao;
import org.cap.model.Customer;

@Service("registerService")
public class RegisterServiceImpl implements IRegisterService{
	
	@Autowired
	IRegisterDao registerDao;
	
	@Override
	public boolean registerCustomer(Customer customerBean) {
		registerDao.save(customerBean);
		return true;
	}
}
