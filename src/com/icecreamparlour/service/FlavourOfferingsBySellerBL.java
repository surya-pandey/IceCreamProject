package com.icecreamparlour.service;

import com.icecreamparlour.entities.FlavourOfferingsBySeller;


public interface FlavourOfferingsBySellerBL {
	public FlavourOfferingsBySeller searchFlavourBL(String flavourName);
	public FlavourOfferingsBySeller getFlavoursBySellerIdBL(int sellerId);
	public boolean enterAllPrices(FlavourOfferingsBySeller flavourOfferingsBySeller, int sellerId, int flavourId);
}
