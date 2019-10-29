package com.icecreamparlour.entities;

public class Flavours {
	
	private int flavourId;
	private String flavourName;
	
	public Flavours() {
		
	}
	
	public Flavours(String flavourName) {
		super();
		this.flavourName = flavourName;
	}
	
	public Flavours(int flavourId, String flavourName) {
		super();
		this.flavourId = flavourId;
		this.flavourName = flavourName;
	}

	public int getFlavourId() {
		return flavourId;
	}

	public void setFlavourId(int flavourId) {
		this.flavourId = flavourId;
	}

	public String getFlavourName() {
		return flavourName;
	}

	public void setFlavourName(String flavourName) {
		this.flavourName = flavourName;
	}

	@Override
	public String toString() {
		return "Flavours [flavourId=" + flavourId + ", flavourName=" + flavourName + "]";
	}

}
