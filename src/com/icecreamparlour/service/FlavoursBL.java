package com.icecreamparlour.service;

import com.icecreamparlour.entities.FlavourOfferingsBySeller;
import com.icecreamparlour.entities.Flavours;

public interface FlavoursBL {
	public boolean addNewFlavourBL(Flavours flavours, FlavourOfferingsBySeller flavourOfferingsBySeller, int sellerId);
	public boolean removeFlavourByNameBL(String flavourName);
	public boolean changeFlavourPriceBL(String flavourName);
}
