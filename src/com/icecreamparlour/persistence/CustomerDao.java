package com.icecreamparlour.persistence;

import java.sql.ResultSet;

import com.icecreamparlour.entities.Customer;

public interface CustomerDao {
	public boolean addCustomerDetails(Customer customer);
	public ResultSet showAllSellers();
}
