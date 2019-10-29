package com.icecreamparlour.entities;

public class FlavourOfferingsBySeller {

	private int simFlavourId;
	private int singleScoupPrice;
	private int doubleScoupPrice;
	private int overloadedPrice;

	public FlavourOfferingsBySeller() {

	}

	public FlavourOfferingsBySeller(int singleScoupPrice, int doubleScoupPrice, int overloadedPrice) {
		super();
		this.singleScoupPrice = singleScoupPrice;
		this.doubleScoupPrice = doubleScoupPrice;
		this.overloadedPrice = overloadedPrice;
	}

	public FlavourOfferingsBySeller(int simFlavourId, int singleScoupPrice, int doubleScoupPrice, int overloadedPrice) {
		super();
		this.simFlavourId = simFlavourId;
		this.singleScoupPrice = singleScoupPrice;
		this.doubleScoupPrice = doubleScoupPrice;
		this.overloadedPrice = overloadedPrice;
	}

	public int getSimFlavourId() {
		return simFlavourId;
	}

	public void setSimFlavourId(int simFlavourId) {
		this.simFlavourId = simFlavourId;
	}

	public int getSingleScoupPrice() {
		return singleScoupPrice;
	}

	public void setSingleScoupPrice(int singleScoupPrice) {
		this.singleScoupPrice = singleScoupPrice;
	}

	public int getDoubleScoupPrice() {
		return doubleScoupPrice;
	}

	public void setDoubleScoupPrice(int doubleScoupPrice) {
		this.doubleScoupPrice = doubleScoupPrice;
	}

	public int getOverloadedPrice() {
		return overloadedPrice;
	}

	public void setOverloadedPrice(int overloadedPrice) {
		this.overloadedPrice = overloadedPrice;
	}

	@Override
	public String toString() {
		return "FlavourOfferingsBySeller [simFlavourId=" + simFlavourId + ", singleScoupPrice=" + singleScoupPrice
				+ ", doubleScoupPrice=" + doubleScoupPrice + ", overloadedPrice=" + overloadedPrice + "]";
	}

}
