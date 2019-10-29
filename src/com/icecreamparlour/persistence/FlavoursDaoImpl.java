package com.icecreamparlour.persistence;

import com.icecreamparlour.entities.Flavours;
import com.icecreamparlour.util.DbConnectionHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FlavoursDaoImpl implements FlavoursDao {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	java.util.Scanner sc = new Scanner(System.in);
	
	@Override
	public boolean addNewFlavour(Flavours flavours, int sellerId) {
		int status = 0;
		
		try {
			connection = DbConnectionHelper.getConnection();

			// 2. Query

			preparedStatement = connection.prepareStatement("insert into Flavour(flavourName, sellerId) values(?,?)");			
			preparedStatement.setString(1, flavours.getFlavourName());
			preparedStatement.setInt(2, sellerId);
			

			status = preparedStatement.executeUpdate();
			
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();

		}	catch(Exception e) {
			e.printStackTrace();
		}
		finally {

			try {
				// 4. Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (status > 0) {
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean removeFlavour(String flavourName) {
		int status = 0;
		try {
			connection = DbConnectionHelper.getConnection();

			// 2. Query

			preparedStatement = connection.prepareStatement("Delete from Flavour where flavourName=?");
			
			preparedStatement.setString(1, flavourName);

			status = preparedStatement.executeUpdate();
			// 3.Process Result
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();

		} finally {

			try {
				// 4. Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(status > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean changeFlavourPrice(String flavourName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getFlavourId(String flavourName, int sellerId) {
		int id = 0;
		
		try {
			connection = DbConnectionHelper.getConnection();

			// 2. Query

			preparedStatement = connection.prepareStatement("select flavourId from Flavour where flavourName=? and sellerId=?");			
			preparedStatement.setString(1, flavourName);
			preparedStatement.setInt(2, sellerId);
			

			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			id = resultSet.getInt("flavourId");
			}
			
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();

		}	catch(Exception e) {
			e.printStackTrace();
		}
		finally {

			try {
				// 4. Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
	}

}
