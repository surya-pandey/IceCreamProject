package com.icecreamparlour.service;

import com.icecreamparlour.entities.Seller;
import com.icecreamparlour.persistence.SellerDaoImpl;

public class SellerBLImpl implements SellerBL {
	
	SellerDaoImpl sellerDaoImpl = new SellerDaoImpl();
		
	@Override
	public Seller searchSellerBL(String sellerPhnNo) {
		Seller seller = sellerDaoImpl.searchSeller(sellerPhnNo);
		return seller;
	}
	
	@Override
	public Seller loginSellerBL(String sellerPhnNo, String sellerPassword) {
		Seller seller = sellerDaoImpl.loginSeller(sellerPhnNo, sellerPassword);
		return seller;
	}

	@Override
	public boolean insertNewSellerBL(Seller seller) {
		boolean status = sellerDaoImpl.insertNewSeller(seller);
		return status;
	}

	@Override
	public boolean deleteSellerBL(String sellerPhnNo) {
		Seller seller = sellerDaoImpl.searchSeller(sellerPhnNo);
		
		int sellerId = seller.getSellerId();
		boolean status = sellerDaoImpl.deleteSeller(sellerId);
		return status;
	}
}
