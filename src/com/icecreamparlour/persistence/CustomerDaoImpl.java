package com.icecreamparlour.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icecreamparlour.entities.Customer;
import com.icecreamparlour.util.DbConnectionHelper;

public class CustomerDaoImpl implements CustomerDao {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public boolean addCustomerDetails(Customer customer) {
		int status = 0;
		try {
			connection = DbConnectionHelper.getConnection();

			preparedStatement = connection
					.prepareStatement("Insert into Customer(customerName, customerPhoneNumber) values(?,?)");

			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getCustomerPhoneNumber());

			status = preparedStatement.executeUpdate();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}

		}
		if (status > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ResultSet showAllSellers() {
		
		try {
			connection = DbConnectionHelper.getConnection();

			preparedStatement = connection.prepareStatement("Select * from Seller");

			resultSet = preparedStatement.executeQuery();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		//	finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		}

		return resultSet;
	}

}
