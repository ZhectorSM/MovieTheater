package com.javafever.auditorium;

public class Auditorium {

	// Attributes
	private int idAuditorium;
	private String seatTotal;
	private boolean vip;
	private int idLocation;

	// Getter and setter
	public int getIdAuditorium() {
		return idAuditorium;
	}

	public void setIdAuditorium(int idAuditorium) {
		this.idAuditorium = idAuditorium;
	}

	public String getSeatTotal() {
		return seatTotal;
	}

	public void setSeatTotal(String seatTotal) {
		this.seatTotal = seatTotal;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public int getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	// hashCode()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAuditorium;
		result = prime * result + idLocation;
		result = prime * result + ((seatTotal == null) ? 0 : seatTotal.hashCode());
		result = prime * result + (vip ? 1231 : 1237);
		return result;
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auditorium other = (Auditorium) obj;
		if (idAuditorium != other.idAuditorium)
			return false;
		if (idLocation != other.idLocation)
			return false;
		if (seatTotal == null) {
			if (other.seatTotal != null)
				return false;
		} else if (!seatTotal.equals(other.seatTotal))
			return false;
		if (vip != other.vip)
			return false;
		return true;
	}

	// toString()
	@Override
	public String toString() {
		return "Auditorium [idAuditorium=" + idAuditorium + ", seatTotal=" + seatTotal + ", vip=" + vip
				+ ", idLocation=" + idLocation + "]";
	}

}
