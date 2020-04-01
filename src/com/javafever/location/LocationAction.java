package com.javafever.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javafever.connection.DbConector;
import com.javafever.connection.EntityActions;

public class LocationAction extends EntityActions<Location> {

	@Override
	public boolean create(Location element) {

		int success;

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement("INSERT into location(location,address) values (?,?)");// Prepare
			// the query
			ps.setString(1, element.getLocation());// Set the values of the query (data to be inserted)
			ps.setString(2, element.getAddress());

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
	public List<Location> read() {

		List<Location> lstLocation = new ArrayList<>();

		try {
			Connection conn = DbConector.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM location");

			ResultSet result = ps.executeQuery();

			while (result.next()) {

				Location location = new Location();
				location.setIdLocation(result.getInt(1));
				location.setLocation(result.getString(2));
				location.setAddress(result.getString(3));

				lstLocation.add(location);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return lstLocation;
	}

	@Override
	public boolean update(Location element) {
		int success;

		try {
			Connection conn = DbConector.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE location SET location = ?, address = ? WHERE id_location = ?");

			ps.setString(1, element.getLocation());
			ps.setString(2, element.getAddress());
			ps.setInt(3, element.getIdLocation());

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
	public boolean delete(Location element) {
		try {

			Connection conn = DbConector.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM location where id_location = ?");

			ps.setInt(1, element.getIdLocation());

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
