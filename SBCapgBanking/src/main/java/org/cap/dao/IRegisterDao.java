package org.cap.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.cap.model.Customer;

@Repository("registerDao")
@Transactional
public interface IRegisterDao extends JpaRepository<Customer,Integer>{

	//public boolean registerCustomer(CustomerBean customerBean);
}
