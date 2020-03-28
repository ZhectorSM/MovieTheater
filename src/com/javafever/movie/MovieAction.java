package com.javafever.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.javafever.connection.DbConector;
import com.javafever.connection.EntityActions;

public class MovieAction extends EntityActions<Movie> {

	@Override
	public boolean create(Movie element) {

		int success;

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement(
					"INSERT into movie(movie_name,id_category,director,actor,movie_year,runtime_minutes,rate) values (?,?,?,?,?,?,?)");// Prepare

			ps.setString(1, element.getMovieName());
			ps.setInt(2, element.getIdCategory());
			ps.setString(3, element.getDirector());
			ps.setString(4, element.getActor());
			ps.setInt(5, element.getMovieYear());
			ps.setInt(6, element.getRuntimeMinutes());
			ps.setString(7, element.getRate());

			success = ps.executeUpdate();

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
	protected List<Movie> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean update(Movie element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean delete(Movie element) {
		// TODO Auto-generated method stub
		return false;
	}
}