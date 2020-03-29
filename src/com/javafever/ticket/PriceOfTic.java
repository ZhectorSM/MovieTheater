package com.javafever.ticket;

public enum PriceOfTic {
	FORKID(7.99), FORADULT(10.99), FORSENIOR(10.50), VIPKID(11.50), VIPADULT(19.99), VIPSENIOR(14.99);

	private double price;

	PriceOfTic(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

}