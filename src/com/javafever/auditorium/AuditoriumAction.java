package com.javafever.auditorium;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	protected List<Auditorium> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean update(Auditorium element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean delete(Auditorium element) {
		// TODO Auto-generated method stub
		return false;
	}

}
