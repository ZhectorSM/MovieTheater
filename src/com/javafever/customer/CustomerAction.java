package com.javafever.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.javafever.connection.DbConector;
import com.javafever.connection.EntityActions;

public class CustomerAction extends EntityActions<Customer>  {
	@Override
	public boolean create(Customer element) {
 
		int success;

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement("INSERT into customer(first_name, last_name,gender,email,points) values (?,?,?,?,?)");// Prepare
																											// the query
			ps.setString(1, element.getFirstName());// Set the values of the query (data to be inserted)
			ps.setString(2, element.getLastName());
			ps.setString(3, element.getGender());
			ps.setString(4, element.getEmail());
			ps.setInt(5, element.getPoints());
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
	protected List<Customer> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean update(Customer element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean delete(Customer element) {
		// TODO Auto-generated method stub
		return false;
	}

}
