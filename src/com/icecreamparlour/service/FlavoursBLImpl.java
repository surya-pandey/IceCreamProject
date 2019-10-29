package com.icecreamparlour.service;

import com.icecreamparlour.entities.FlavourOfferingsBySeller;
import com.icecreamparlour.entities.Flavours;
import com.icecreamparlour.persistence.FlavourOfferingsBySellerDao;
import com.icecreamparlour.persistence.FlavourOfferingsBySellerDaoImpl;
import com.icecreamparlour.persistence.FlavoursDaoImpl;

public class FlavoursBLImpl implements FlavoursBL {
	
	FlavoursDaoImpl flavoursDaoImpl = new FlavoursDaoImpl();
	
	@Override
	public boolean addNewFlavourBL(Flavours flavours, FlavourOfferingsBySeller flavourOfferingsBySeller, int sellerId) {
		boolean status = flavoursDaoImpl.addNewFlavour(flavours, sellerId);
		int flavourId = flavoursDaoImpl.getFlavourId(flavours.getFlavourName(), sellerId);
		System.out.println("---------------------------------");
		System.out.println(flavourId);
		FlavourOfferingsBySellerDao flavourOfferingsBySellerDaoImpl = new FlavourOfferingsBySellerDaoImpl();
		flavourOfferingsBySellerDaoImpl.enterAllPrices(flavourOfferingsBySeller, sellerId, flavourId);
		return status;
	}

	@Override
	public boolean removeFlavourByNameBL(String flavourName) {
		boolean status = flavoursDaoImpl.removeFlavour(flavourName);
		return status;
	}

	@Override
	public boolean changeFlavourPriceBL(String flavourName) {
		flavoursDaoImpl.changeFlavourPrice(flavourName);
		return false;
	}
}
