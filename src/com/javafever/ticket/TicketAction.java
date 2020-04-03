package com.javafever.ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.javafever.connection.DbConector;
import com.javafever.connection.EntityActions;

public class TicketAction extends EntityActions<Ticket> {

	@Override
	public boolean create(Ticket element) {

		int success;

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement(
					"insert into ticket (id_loyal_program,id_customer,id_schedule,seat) values (?,?,?,?)");// Prepare
			// the query
			ps.setInt(1, element.getIdLoyalProgram());// Set the values of the query (data to be inserted)
			ps.setInt(2, element.getIdCustomer());
			ps.setInt(3, element.getMovieFunction().getIdSchedule());
			ps.setInt(4, element.getSeat());

			success = ps.executeUpdate();// Execute the query in the db update, insert,delete

			if (success > 0) {// If the operation was succesful we return true
				return true;
			}

		} catch (Exception e) {// If there is an error in the operation
			System.out.println("Error: " + e.getMessage());
		}

		// If the operation went wrong return false
		return false;

	}

	@Override
	public List<Ticket> read() {

		List<Ticket> lstTicket = new ArrayList<>();

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ticket");// Prepare
			ResultSet result = ps.executeQuery();// Execute query for select

			while (result.next()) {

				Ticket ticket = new Ticket();// Creating a list
				ticket.setIdTicket(result.getInt(1));// Get the int value of the column 1
				ticket.setIdLoyalProgram(result.getInt(2));
				ticket.setIdCustomer(result.getInt(3));
				ticket.setIdSchedule(result.getInt(4));
				ticket.setSeat(result.getInt(5));

				lstTicket.add(ticket);// Add element to the list
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return lstTicket;

	}

	public List<Ticket> readBySchedule(int idSchedule) {

		List<Ticket> lstTicket = new ArrayList<>();

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ticket where id_schedule = ?");// Prepare
			ps.setInt(1, idSchedule);

			ResultSet result = ps.executeQuery();// Execute query for select

			while (result.next()) {

				Ticket ticket = new Ticket();// Creating a list
				ticket.setIdTicket(result.getInt(1));// Get the int value of the column 1
				ticket.setIdLoyalProgram(result.getInt(2));
				ticket.setIdCustomer(result.getInt(3));
				ticket.setIdSchedule(result.getInt(4));
				ticket.setSeat(result.getInt(5));

				lstTicket.add(ticket);// Add element to the list
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return lstTicket;

	}

	@Override
	public boolean update(Ticket element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Ticket element) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<MovieFunction> getMovieFuntions(int idMovie) {

		List<MovieFunction> lstMovieFunc = new ArrayList<>();

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement(
					"SELECT theatre_schedule.id_schedule, theatre_schedule.showtime, theatre_schedule.id_auditorium, movie.movie_name, theatre_schedule.price, auditorium.vip, location.address "
							+ " FROM theatre_schedule inner join movie on theatre_schedule.id_movie = movie.id_movie "
							+ " inner join auditorium on theatre_schedule.id_auditorium = auditorium.id_auditorium"
							+ " inner join location on auditorium.id_auditorium = location.id_location"
							+ " where theatre_schedule.id_movie = ?");// Prepare

			ps.setInt(1, idMovie);
			ResultSet result = ps.executeQuery();// Execute query for select

			while (result.next()) {

				MovieFunction moviFunc = new MovieFunction();// Creating a list
				moviFunc.setIdSchedule(result.getInt(1));
				moviFunc.setShowtime(result.getObject(2, LocalDateTime.class));
				moviFunc.setIdAuditorium(result.getInt(3));
				moviFunc.setMovieName(result.getString(4));
				moviFunc.setPrice(result.getDouble(5));
				moviFunc.setVip(result.getBoolean(6));
				moviFunc.setAddress(result.getString(7));

				lstMovieFunc.add(moviFunc);// Add element to the list
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return lstMovieFunc;

	}

}
