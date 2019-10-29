package com.icecreamparlour.service;

import com.icecreamparlour.entities.Seller;

public interface SellerBL {
	public Seller loginSellerBL(String sellerPhnNo, String sellerPassword);
	public Seller searchSellerBL(String sellerName);
	public boolean insertNewSellerBL(Seller seller);
	public boolean deleteSellerBL(String sellerPhnNo);
}
