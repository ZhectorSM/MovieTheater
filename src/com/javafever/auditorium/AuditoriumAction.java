package com.javafever.auditorium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javafever.connection.DbConector;
import com.javafever.connection.EntityActions;

public class AuditoriumAction extends EntityActions<Auditorium> {

	@Override
	public boolean create(Auditorium element) {

		int success;

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn
					.prepareStatement("INSERT into auditorium(seat_total, vip, id_location) values (?,?,?)");// Prepare
			// the query
			ps.setString(1, element.getSeatTotal());// Set the values of the query (data to be inserted)
			ps.setBoolean(2, element.isVip());
			ps.setInt(3, element.getIdLocation());
			success = ps.executeUpdate();// Execute the query in the db

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
	public List<Auditorium> read() {

		List<Auditorium> lstAuditorium = new ArrayList<>();

		try {
			Connection conn = DbConector.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM auditorium");
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				Auditorium auditorium = new Auditorium();
				auditorium.setIdAuditorium(result.getInt(1));
				auditorium.setSeatTotal(result.getString(2));
				auditorium.setVip(result.getBoolean(3));
				auditorium.setIdLocation(result.getInt(4));

				lstAuditorium.add(auditorium);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return lstAuditorium;
	}

	@Override
	public boolean update(Auditorium element) {
		int success;

		try {
			Connection conn = DbConector.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE auditorium SET seat_total = ?, vip = ? WHERE id_auditorium = ?");
			ps.setString(1, element.getSeatTotal());
			ps.setBoolean(2, element.isVip());
			ps.setInt(3, element.getIdAuditorium());

			success = ps.executeUpdate();

			if (success > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Auditorium element) {
		try {
			Connection conn = DbConector.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM auditorium where id_auditorium = ?");

			ps.setInt(1, element.getIdAuditorium());

			int success = ps.executeUpdate();

			if (success > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;
	}
}
