package com.javafever.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	protected List<Location> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean update(Location element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean delete(Location element) {
		// TODO Auto-generated method stub
		return false;
	}

}
