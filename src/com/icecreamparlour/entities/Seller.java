package com.icecreamparlour.entities;

public class Seller {
	private int sellerId;
	private String sellerName;
	private String sellerPhnNo;
	private String sellerEmail;
	private String sellerPassword;
	
	public Seller() {
		
	}
	
	public Seller(String sellerName, String sellerPhnNo, String sellerEmail, String sellerPassword) {
		super();
		this.sellerName = sellerName;
		this.sellerPhnNo = sellerPhnNo;
		this.sellerEmail = sellerEmail;
		this.sellerPassword = sellerPassword;
	}
	
	public Seller(int sellerId, String sellerName, String sellerPhnNo, String sellerEmail, String sellerPassword) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerPhnNo = sellerPhnNo;
		this.sellerEmail = sellerEmail;
		this.sellerPassword = sellerPassword;
	}
	
	public int getSellerId() {
		return sellerId;
	}
	
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	
	public String getSellerName() {
		return sellerName;
	}
	
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	public String getSellerPhnNo() {
		return sellerPhnNo;
	}
	
	public void setSellerPhnNo(String sellerPhnNo) {
		this.sellerPhnNo = sellerPhnNo;
	}
	
	public String getSellerEmail() {
		return sellerEmail;
	}
	
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	
	public String getSellerPassword() {
		return sellerPassword;
	}
	
	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + ", sellerPhnNo=" + sellerPhnNo
				+ ", sellerEmail=" + sellerEmail + ", sellerPassword=" + sellerPassword + "]";
	}
	
}
