package com.icecreamparlour.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.icecreamparlour.entities.FlavourOfferingsBySeller;
import com.icecreamparlour.entities.Flavours;
import com.icecreamparlour.util.DbConnectionHelper;

public class FlavourOfferingsBySellerDaoImpl implements FlavourOfferingsBySellerDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public FlavourOfferingsBySeller searchFlavour(String flavour) {

		FlavourOfferingsBySeller flavourOffering = new FlavourOfferingsBySeller();
		try {
			connection = DbConnectionHelper.getConnection();
			preparedStatement = connection.prepareStatement(
					"select FlavourOfferingBySeller.*,Flavour.flavourName from FlavourOfferingBySeller left join Flavour ON Flavour.flavourId = FlavourOfferingBySeller.flavourId where Flavour.flavourName=? ");
			preparedStatement.setString(1, "flavourName");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				flavourOffering.setSingleScoupPrice(resultSet.getInt("singleScoupPrice"));
				flavourOffering.setDoubleScoupPrice(resultSet.getInt("doubleScoupPrice"));
				flavourOffering.setOverloadedPrice(resultSet.getInt("overLoadedPrice"));
			}
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
		return flavourOffering;
	}

	@Override
	public boolean enterAllPrices(FlavourOfferingsBySeller flavourOfferingsBySeller, int sellerId, int flavourId) {
		int status = 0;
		Random random = new Random();
		int count = random.nextInt(100);
		try {
			connection = DbConnectionHelper.getConnection();
			preparedStatement = connection.prepareStatement("Insert into FlavourOfferingBySeller(simFlavourId, sellerId, flavourId, singleScoupPrice, doubleScoupPrice, overLoadedPrice) values(?,?,?,?,?,?)");
			
			preparedStatement.setInt(1, count);
			preparedStatement.setInt(2, sellerId);
			preparedStatement.setInt(3, flavourId);
			preparedStatement.setInt(4, flavourOfferingsBySeller.getSingleScoupPrice());
			preparedStatement.setInt(5, flavourOfferingsBySeller.getDoubleScoupPrice());
			preparedStatement.setInt(6, flavourOfferingsBySeller.getOverloadedPrice());
			
			
			
			status = preparedStatement.executeUpdate();
			
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();

		} finally {

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (status > 0) {
			count++;
			System.out.println("Prices Inserted");
			return true;
		} else {
			System.out.println("Prices Not Inserted");
			return false;
		}
		
	}
	
	@Override
	public FlavourOfferingsBySeller getAllFlavoursBySeller(int sellerId) {
		
		FlavourOfferingsBySeller flavourOfferingsBySeller = new FlavourOfferingsBySeller();
		
		try {
			connection = DbConnectionHelper.getConnection();
			
			preparedStatement = connection.prepareStatement("Select * from FlavourOfferingBySeller where sellerId = ?");
			
			preparedStatement.setInt(1, sellerId);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				flavourOfferingsBySeller.setSingleScoupPrice(resultSet.getInt("singleScoupPrice"));
				flavourOfferingsBySeller.setDoubleScoupPrice(resultSet.getInt("doubleScoupPrice"));
				flavourOfferingsBySeller.setOverloadedPrice(resultSet.getInt("overLoadedPrice"));
			}
			
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
		return flavourOfferingsBySeller;
	}
	
	@Override
	public Flavours getFlavoursBySellerId(int sellerId) {

		Flavours flavours = new Flavours();
		try {
			connection = DbConnectionHelper.getConnection();
			preparedStatement = connection.prepareStatement(
					"select FlavourOfferingBySeller.*, Flavour.flavourName, Seller.sellerName from FlavourOfferingBySeller Left Join Flavour on FlavourOfferingBySeller.flavourId = Flavour.flavourId Left Join Seller on FlavourOfferingBySeller.sellerId = Seller.sellerId where Seller.sellerId = ?");
			preparedStatement.setInt(1, sellerId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				flavours.setFlavourName(resultSet.getString("flavourName"));
			}
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
		return flavours;
	}

}