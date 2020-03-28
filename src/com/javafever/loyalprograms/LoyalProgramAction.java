package com.javafever.loyalprograms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.javafever.category.Category;
import com.javafever.connection.DbConector;
import com.javafever.connection.EntityActions;
import com.javafever.customer.Customer;

public class LoyalProgramAction extends EntityActions<LoyalPrograms> {
	@Override
	public boolean create(LoyalPrograms element) {

		int success;

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement("INSERT into loyal_program(discount,minimum_points) values (?,?)");// Prepare
																											// the query
			ps.setFloat(1, element.getDiscount());// Set the values of the query (data to be inserted)
			ps.setInt(2, element.getMinimumPoints());

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
	protected List<LoyalPrograms> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean update(LoyalPrograms element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean delete(LoyalPrograms element) {
		// TODO Auto-generated method stub
		return false;
	}

}
