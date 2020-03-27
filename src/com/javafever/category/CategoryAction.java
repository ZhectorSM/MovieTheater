package com.javafever.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.javafever.connection.DbConector;
import com.javafever.connection.EntityActions;

public class CategoryAction extends EntityActions<Category> {

	@Override
	public boolean create(Category element) {

		int success;

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement("INSERT into category(category_name) values (?)");// Prepare
																											// the query
			ps.setString(1, element.getCategoryName());// Set the values of the query (data to be inserted)

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
	protected List<Category> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean update(Category element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean delete(Category element) {
		// TODO Auto-generated method stub
		return false;
	}

}
