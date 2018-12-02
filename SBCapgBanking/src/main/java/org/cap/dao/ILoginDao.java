package org.cap.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.cap.model.Customer;
import org.cap.model.LoginPojo;

@Repository("loginDao")
@Transactional
public interface ILoginDao extends JpaRepository<Customer,Integer>{

	public Customer getCustomerByEmailIdAndCustomerPwd(String email,String customerPwd);
}
