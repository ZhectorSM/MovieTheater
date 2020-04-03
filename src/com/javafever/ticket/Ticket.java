package com.javafever.ticket;

public class Ticket {

	private int idTicket;
	private int idLoyalProgram;
	private int idCustomer;
	private int idSchedule;
	private int idMovie;
	private int seat;

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public int getIdLoyalProgram() {
		return idLoyalProgram;
	}

	public void setIdLoyalProgram(int idLoyalProgram) {
		this.idLoyalProgram = idLoyalProgram;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCustomer;
		result = prime * result + idLoyalProgram;
		result = prime * result + idMovie;
		result = prime * result + idSchedule;
		result = prime * result + idTicket;
		result = prime * result + seat;
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
		Ticket other = (Ticket) obj;
		if (idCustomer != other.idCustomer)
			return false;
		if (idLoyalProgram != other.idLoyalProgram)
			return false;
		if (idMovie != other.idMovie)
			return false;
		if (idSchedule != other.idSchedule)
			return false;
		if (idTicket != other.idTicket)
			return false;
		if (seat != other.seat)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", idLoyalProgram=" + idLoyalProgram + ", idCustomer=" + idCustomer
				+ ", idSchedule=" + idSchedule + ", idMovie=" + idMovie + ", seat=" + seat + "]";
	}

}
