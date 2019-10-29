package com.icecreamparlour.service;

import com.icecreamparlour.entities.FlavourOfferingsBySeller;
import com.icecreamparlour.entities.Flavours;
import com.icecreamparlour.persistence.FlavourOfferingsBySellerDaoImpl;

public class FlavourOfferingsBySellerBLImpl implements FlavourOfferingsBySellerBL {
	
	FlavourOfferingsBySellerDaoImpl flavourOfferingsBySellerDaoImpl = new FlavourOfferingsBySellerDaoImpl();
	
	@Override
	public FlavourOfferingsBySeller searchFlavourBL(String flavourName) {
		FlavourOfferingsBySeller flavourOfferingsBySeller = flavourOfferingsBySellerDaoImpl.searchFlavour(flavourName);
		return flavourOfferingsBySeller;
	}

	@Override
	public FlavourOfferingsBySeller getFlavoursBySellerIdBL(int sellerId) {
		FlavourOfferingsBySeller flavourOfferingsBySeller = flavourOfferingsBySellerDaoImpl.getAllFlavoursBySeller(sellerId);
		return flavourOfferingsBySeller;
	}

	@Override
	public boolean enterAllPrices(FlavourOfferingsBySeller flavourOfferingsBySeller, int sellerId, int flavourId) {
		boolean status = flavourOfferingsBySellerDaoImpl.enterAllPrices(flavourOfferingsBySeller, sellerId, flavourId);
		return status;
	}
}
