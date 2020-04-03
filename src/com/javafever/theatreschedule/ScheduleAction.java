package com.javafever.theatreschedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.javafever.connection.DbConector;
import com.javafever.connection.EntityActions;;

public class ScheduleAction extends EntityActions<TheatreSchedule> {

	@Override
	public boolean create(TheatreSchedule element) {

		int success;

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement(
					"INSERT into theatre_schedule(showtime,id_auditorium,id_movie,price,seat) values (?,?,?,?)");// Prepare

			ps.setObject(1, element.getShowtime());
			ps.setInt(2, element.getIdAuditorium());
			ps.setInt(3, element.getIdMovie());
			ps.setFloat(4, element.getPrice());
			success = ps.executeUpdate();

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
	public List<TheatreSchedule> read() {

		List<TheatreSchedule> lstSchedule = new ArrayList<>();

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM theatre_schedule");// Prepare
			ResultSet result = ps.executeQuery();// Execute query for select

			while (result.next()) {

				TheatreSchedule schedule = new TheatreSchedule();// Creating a list
				schedule.setIdSchedule(result.getInt(1));// Get the int value of the column 1
				schedule.setShowtime(result.getObject(2, LocalDateTime.class));
				schedule.setIdAuditorium(result.getInt(3));
				schedule.setIdMovie(result.getInt(4));
				schedule.setPrice(result.getFloat(5));

				lstSchedule.add(schedule);// Add element to the list
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lstSchedule;
	}

	@Override
	public boolean update(TheatreSchedule element) {

		int success;

		try {
			Connection conn = DbConector.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE theatre_schedule SET showtime = ? , id_auditorium = ?, id_movie = ?, price = ? WHERE id_schedule = ?");

			ps.setObject(1, element.getShowtime());
			ps.setInt(2, element.getIdAuditorium());
			ps.setInt(3, element.getIdMovie());
			ps.setFloat(4, element.getPrice());

			ps.setInt(6, element.getIdSchedule());

			success = ps.executeUpdate();

			if (success > 0) {// Operation succesful
				return true;
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return false;
	}

	@Override
	public boolean delete(TheatreSchedule element) {

		try {

			Connection conn = DbConector.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM theatre_schedule where id_schedule = ?");

			ps.setInt(1, element.getIdSchedule());

			int success = ps.executeUpdate();

			if (success > 0) {// If the operation was succesful we return true
				return true;
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;
	}

	public List<TheatreSchedule> readByIdMovie(int movieId) {

		List<TheatreSchedule> lstSchedule = new ArrayList<>();

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM theatre_schedule where id_movie = ?" + "");// Prepare
			ps.setInt(1, movieId);

			ResultSet result = ps.executeQuery();// Execute query for select

			while (result.next()) {

				TheatreSchedule schedule = new TheatreSchedule();// Creating a list
				schedule.setIdSchedule(result.getInt(1));// Get the int value of the column 1
				schedule.setShowtime(result.getObject(2, LocalDateTime.class));
				schedule.setIdAuditorium(result.getInt(3));
				schedule.setIdMovie(result.getInt(4));
				schedule.setPrice(result.getFloat(5));

				lstSchedule.add(schedule);// Add element to the list
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lstSchedule;
	}

}
