package com.javafever.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javafever.connection.DbConector;
import com.javafever.connection.EntityActions;

public class UserAction extends EntityActions<User> {

	@Override
	protected boolean create(User element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> read() {

		List<User> lstUser = new ArrayList<>();

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user");// Prepare
			ResultSet result = ps.executeQuery();// Execute query for select

			while (result.next()) {

				User User = new User();// Creating a list
				User.setIdUser(result.getInt(1));// Get the int value of the column 1
				User.setName(result.getString(2));// Get the String value of the column 2
				User.setPwd(result.getString(3));
				User.setRole(result.getString(4));

				lstUser.add(User);// Add element to the list
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return lstUser;

	}

	@Override
	protected boolean update(User element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean delete(User element) {
		// TODO Auto-generated method stub
		return false;
	}

}
