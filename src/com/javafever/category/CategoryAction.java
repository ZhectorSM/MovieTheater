package com.javafever.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

			success = ps.executeUpdate();// Execute the query in the db update, insert,delete

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
	public List<Category> read() {

		List<Category> lstCategory = new ArrayList<>();

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM category");// Prepare
			ResultSet result = ps.executeQuery();// Execute query for select

			while (result.next()) {

				Category category = new Category();// Creating a list
				category.setIdCategory(result.getInt(1));// Get the int value of the column 1
				category.setCategoryName(result.getString(2));// Get the String value of the column 2

				lstCategory.add(category);// Add element to the list
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return lstCategory;

	}

	@Override
	protected boolean update(Category element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category element) {
		try {

			Connection conn = DbConector.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM category where id_category = ?");

			ps.setInt(1, element.getIdCategory());

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
