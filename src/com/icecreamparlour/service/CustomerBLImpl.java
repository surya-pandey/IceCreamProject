package com.icecreamparlour.service;

import java.sql.ResultSet;

import com.icecreamparlour.entities.Customer;
import com.icecreamparlour.persistence.CustomerDaoImpl;

public class CustomerBLImpl implements CustomerBL {
	
	CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
	
	@Override
	public boolean addCustomerDetailsBL(Customer customer) {
		boolean status = customerDaoImpl.addCustomerDetails(customer);
		return status;
	}
	
	@Override
	public ResultSet showAllSellersBL() {
		ResultSet resultSet = customerDaoImpl.showAllSellers();
		return resultSet;
	}
}
