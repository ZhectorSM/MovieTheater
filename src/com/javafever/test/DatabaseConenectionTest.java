package com.javafever.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.javafever.connection.DbConector;

public class DatabaseConenectionTest {

	public static void main(String[] args) throws SQLException {

		Connection con = DbConector.getConnection();
		con.close();

	}

}
