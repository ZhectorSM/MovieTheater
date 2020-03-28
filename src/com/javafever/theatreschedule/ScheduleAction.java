package com.javafever.theatreschedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
					"INSERT into theatre_schedule(showtime,id_auditorium,id_movie,price,seat) values (?,?,?,?,?)");// Prepare

			ps.setObject(1, element.getShowtime());
			ps.setInt(2, element.getIdAuditorium());
			ps.setInt(3, element.getIdMovie());
			ps.setFloat(4, element.getPrice());
			ps.setInt(5, element.getSeat());
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
	protected List<TheatreSchedule> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean update(TheatreSchedule element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean delete(TheatreSchedule element) {
		// TODO Auto-generated method stub
		return false;
	}
}
