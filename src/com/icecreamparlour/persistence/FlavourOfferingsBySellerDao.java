package com.icecreamparlour.persistence;

import com.icecreamparlour.entities.FlavourOfferingsBySeller;
import com.icecreamparlour.entities.Flavours;

public interface FlavourOfferingsBySellerDao {
	public FlavourOfferingsBySeller searchFlavour(String flavour);
	public FlavourOfferingsBySeller getAllFlavoursBySeller(int sellerId);
	public boolean enterAllPrices(FlavourOfferingsBySeller flavourOfferingsBySeller, int sellerId, int flavourId);
	public Flavours getFlavoursBySellerId(int sellerId);
}
