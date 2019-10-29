package com.icecreamparlour.persistence;

import com.icecreamparlour.entities.Seller;

public interface SellerDao {
	public Seller searchSeller(String sellerPhnNo);
	public Seller loginSeller(String sellerPhnNo, String sellerPassword);
	public boolean insertNewSeller(Seller seller);
	public boolean deleteSeller(int sellerId);
}
