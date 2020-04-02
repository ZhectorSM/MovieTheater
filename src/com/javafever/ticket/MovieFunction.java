package com.javafever.ticket;

import java.time.LocalDateTime;

public class MovieFunction {

	private int idSchedule;
	private LocalDateTime showtime;
	private int idAuditorium;
	private String movieName;
	private double price;
	private boolean vip;
	private String address;

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

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MovieFunction [idSchedule=" + idSchedule + ", showtime=" + showtime + ", idAuditorium=" + idAuditorium
				+ ", movieName=" + movieName + ", price=" + price + ", vip=" + vip + ", address=" + address + "]";
	}

}
