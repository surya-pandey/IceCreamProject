package com.icecreamparlour.persistence;

import com.icecreamparlour.entities.Flavours;

public interface FlavoursDao {
	public boolean addNewFlavour(Flavours flavours, int sellerId);
	public boolean removeFlavour(String flavourName);
	public boolean changeFlavourPrice(String flavourName);
	public int getFlavourId(String flavourName, int sellerId);
}
