package com.javafever.loyalprograms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
	public List<LoyalPrograms> read() {

		List<LoyalPrograms> lstLoyalPrograms = new ArrayList<>();

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM loyal_program");// Prepare
			ResultSet result = ps.executeQuery();// Execute query for select

			while (result.next()) {

				LoyalPrograms loyalprograms = new LoyalPrograms();// Creating a list
				loyalprograms.setIdLoyalProgram(result.getInt(1));// Get the int value of the column 1
				loyalprograms.setDiscount(result.getFloat(2));
				loyalprograms.setMinimumPoints(result.getInt(3));// Get the String value of the column 2

				lstLoyalPrograms.add(loyalprograms);// Add element to the list
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return lstLoyalPrograms;

	}


	@Override
	protected boolean update(LoyalPrograms element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(LoyalPrograms element) {
		try {

			Connection conn = DbConector.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM loyal_program where id_loyal_program = ?");

			ps.setInt(1, element.getIdLoyalProgram());

			int success = ps.executeUpdate();

			if (success > 0) {// If the operation was succesful we return true
				return true;
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return false;
	}

}
