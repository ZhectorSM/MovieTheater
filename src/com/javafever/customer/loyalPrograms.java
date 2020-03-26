package com.javafever.customer;

public class loyalPrograms {
	private int idLoyalProgram;
	private float discount;
	private  int minimumPoints;
	public int getIdLoyalProgram() {
		return idLoyalProgram;
	}
	public void setIdLoyalProgram(int idLoyalProgram) {
		this.idLoyalProgram = idLoyalProgram;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getMinimumPoints() {
		return minimumPoints;
	}
	public void setMinimumPoints(int minimumPoints) {
		this.minimumPoints = minimumPoints;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(discount);
		result = prime * result + idLoyalProgram;
		result = prime * result + minimumPoints;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		loyalPrograms other = (loyalPrograms) obj;
		if (Float.floatToIntBits(discount) != Float.floatToIntBits(other.discount))
			return false;
		if (idLoyalProgram != other.idLoyalProgram)
			return false;
		if (minimumPoints != other.minimumPoints)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "loyalPrograms [idLoyalProgram=" + idLoyalProgram + ", discount=" + discount + ", minimumPoints="
				+ minimumPoints + "]";
	}
	
}