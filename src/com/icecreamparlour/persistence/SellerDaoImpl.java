package com.icecreamparlour.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.icecreamparlour.util.DbConnectionHelper;
import com.icecreamparlour.entities.Seller;

public class SellerDaoImpl implements SellerDao {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Seller seller = new Seller();
	Scanner scanner = new Scanner(System.in);

	@Override
	public Seller searchSeller(String sellerPhnNo) {
		try {
			connection = DbConnectionHelper.getConnection();
			preparedStatement = connection.prepareStatement("select * from Seller where sellerPhnNo = ?");

			preparedStatement.setString(1, sellerPhnNo);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				seller.setSellerName(resultSet.getString("sellerName"));
				seller.setSellerEmail(resultSet.getString("sellerEmail"));
				seller.setSellerPhnNo(resultSet.getString("sellerPhnNo"));
				seller.setSellerId(resultSet.getInt("sellerId"));
			}
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return seller;

	}

	@Override
	public boolean insertNewSeller(Seller seller) {
		int status = 0;
		try {
			connection = DbConnectionHelper.getConnection();

			// 2. Query

			preparedStatement = connection.prepareStatement(
					"insert into Seller(sellerName, sellerPhnNo, sellerEmail, sellerPassword) values(?,?,?,?)");

			preparedStatement.setString(1, seller.getSellerName());
			preparedStatement.setString(2, seller.getSellerPhnNo());
			preparedStatement.setString(3, seller.getSellerEmail());
			preparedStatement.setString(4, seller.getSellerPassword());

			status = preparedStatement.executeUpdate();

			// 3.Process Result

		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();

		} finally {

			try {
				// 4. Close
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (status > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteSeller(int sellerId) {
		int status = 0;
		try {
			connection = DbConnectionHelper.getConnection();

			System.out.println("*****************************");
			System.out.println(sellerId);
			
			PreparedStatement preparedStatement2 = null;
			preparedStatement2 = connection.prepareStatement(
					"Delete from FlavourOfferingBySeller where sellerId=?");
			preparedStatement2.setInt(1, sellerId);
			preparedStatement2.executeUpdate();
			
			PreparedStatement preparedStatement1 = null;
			preparedStatement1 = connection.prepareStatement(
					"Delete from Flavour where sellerId=?");
			preparedStatement1.setInt(1, sellerId);
			preparedStatement1.executeUpdate();
			
			preparedStatement = connection.prepareStatement(
					"Delete from Seller where sellerId = ?");
			preparedStatement.setInt(1, sellerId);
			status = preparedStatement.executeUpdate();
			
			
			
			
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();

		} finally {

			try {
				// 4. Close
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (status > 0)
			return true;
		else
			return false;
	}

	@Override
	public Seller loginSeller(String sellerPhnNo, String sellerPassword) {
		try {
			connection = DbConnectionHelper.getConnection();
			preparedStatement = connection.prepareStatement("select * from Seller where sellerPhnNo = ? and sellerPassword = ?");

			preparedStatement.setString(1, sellerPhnNo);
			preparedStatement.setString(2, sellerPassword);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				seller.setSellerName(resultSet.getString("sellerName"));
				seller.setSellerEmail(resultSet.getString("sellerEmail"));
				seller.setSellerPhnNo(resultSet.getString("sellerPhnNo"));
				seller.setSellerId(resultSet.getInt("sellerId"));
			}
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return seller;
	}

}
