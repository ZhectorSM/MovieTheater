package com.javafever.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
	public List<Movie> read() {
		List<Movie> lstMovie = new ArrayList<>();

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM movie");// Prepare
			ResultSet result = ps.executeQuery();// Execute query for select

			while (result.next()) {

				Movie movie = new Movie();// Creating a list
				movie.setIdMovie(result.getInt(1));// Get the int value of the column 1
				movie.setMovieName(result.getString(2));
				movie.setIdCategory(result.getInt(3));
				movie.setDirector(result.getString(4));
				movie.setActor(result.getString(5));
				movie.setMovieYear(result.getInt(6));
				movie.setRuntimeMinutes(result.getInt(7));
				movie.setRate(result.getString(8));

				lstMovie.add(movie);// Add element to the list
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return lstMovie;

	}

	@Override
	public boolean update(Movie element) {

		int success;

		try {
			Connection conn = DbConector.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE movie SET movie_name = ? , id_category = ?, director = ?, actor = ?, movie_year = ?, runtime_minutes = ?, rate = ?  WHERE id_movie = ?");

			ps.setString(1, element.getMovieName());
			ps.setInt(2, element.getIdCategory());
			ps.setString(3, element.getDirector());
			ps.setString(4, element.getActor());
			ps.setInt(5, element.getMovieYear());
			ps.setInt(6, element.getRuntimeMinutes());
			ps.setString(7, element.getRate());

			ps.setInt(8, element.getIdMovie());

			success = ps.executeUpdate();

			if (success > 0) {// Operation succesful
				return true;
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return false;
	}

	@Override
	public boolean delete(Movie element) {
		try {

			Connection conn = DbConector.getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM movie where id_movie = ?");

			ps.setInt(1, element.getIdMovie());

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