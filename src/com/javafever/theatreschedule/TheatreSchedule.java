package com.javafever.theatreschedule;

import java.time.LocalDateTime;

public class TheatreSchedule {

	private int idSchedule;
	private LocalDateTime showtime;
	private int idAuditorium;
	private int idMovie;
	private float price;
	private int seat;

	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}

	public LocalDateTime getShowtime() {
		return showtime;
	}

	public void setShowtime(LocalDateTime showtime) {
		this.showtime = showtime;
	}

	public int getIdAuditorium() {
		return idAuditorium;
	}

	public void setIdAuditorium(int idAuditorium) {
		this.idAuditorium = idAuditorium;
	}

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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
		result = prime * result + idAuditorium;
		result = prime * result + idMovie;
		result = prime * result + idSchedule;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + seat;
		result = prime * result + ((showtime == null) ? 0 : showtime.hashCode());
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
		TheatreSchedule other = (TheatreSchedule) obj;
		if (idAuditorium != other.idAuditorium)
			return false;
		if (idMovie != other.idMovie)
			return false;
		if (idSchedule != other.idSchedule)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (seat != other.seat)
			return false;
		if (showtime == null) {
			if (other.showtime != null)
				return false;
		} else if (!showtime.equals(other.showtime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TheatreSchedul1 [idSchedule=" + idSchedule + ", showtime=" + showtime + ", idAuditorium=" + idAuditorium
				+ ", idMovie=" + idMovie + ", price=" + price + ", seat=" + seat + "]";
	}

}
