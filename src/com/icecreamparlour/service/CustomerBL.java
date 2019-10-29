package com.icecreamparlour.service;

import java.sql.ResultSet;

import com.icecreamparlour.entities.Customer;

public interface CustomerBL {
	public boolean addCustomerDetailsBL(Customer customer);
	public ResultSet showAllSellersBL();
}
