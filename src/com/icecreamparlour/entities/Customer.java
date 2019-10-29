package com.icecreamparlour.entities;

public class Customer {

	private int customerId;
	private String customerName;
	private String customerPhoneNumber;
	
	public Customer() {
		
	}
	
	public Customer(String customerName, String customerPhoneNumber) {
		super();
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
	}
	
	public Customer(int customerId, String customerName, String customerPhoneNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPhoneNumber="
				+ customerPhoneNumber + "]";
	}
	
}
