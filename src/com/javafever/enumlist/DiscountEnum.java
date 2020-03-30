package com.javafever.enumlist;

public class DiscountEnum {
	
	enum Discount{
		TEN(10),TWENTY(20),FIFTY(50),HUNDRED(100);

Discount(int discount) {
	// TODO Auto-generated constructor stub
	this.discount = discount;
}
		
	private int discount;
	
	
	public int getDiscount() {
		return discount;
	}
}

	public static void main(String[] args) {
		System.out.println(Discount.TEN.getDiscount());
    
	}

}