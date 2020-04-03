package com.javafever.ticket;

import com.javafever.auditorium.Auditorium;
import com.javafever.customer.Customer;
import com.javafever.movie.Movie;

public class Ticket {

	private int idTicket;
	private int idLoyalProgram;
	private int idCustomer;
	private int idSchedule;
	private int seat;
	private Customer customer;
	private Movie movie;
	private Auditorium auditorium;
	private MovieFunction movieFunction;

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

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

	public MovieFunction getMovieFunction() {
		return movieFunction;
	}

	public void setMovieFunction(MovieFunction movieFunction) {
		this.movieFunction = movieFunction;
	}

	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", idLoyalProgram=" + idLoyalProgram + ", idCustomer=" + idCustomer
				+ ", idSchedule=" + idSchedule + ", seat=" + seat + ", customer=" + customer + ", movie=" + movie
				+ ", auditorium=" + auditorium + ", movieFunction=" + movieFunction + "]";
	}

}
