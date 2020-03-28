package com.javafever.test;

import com.javafever.movie.Movie;
import com.javafever.movie.MovieAction;

public class MovieInsertetionTest {

	public static void main(String[] args) {

		// Create category object
		Movie myMovie = new Movie();
		myMovie.setMovieName("Avengers: Endgame");// Setting values
		myMovie.setIdCategory(1);
		myMovie.setDirector("Anthony Russo");
		myMovie.setActor("Chris Evans");
		myMovie.setMovieYear(2019);
		myMovie.setRuntimeMinutes(182);
		myMovie.setRate("PG13");
		System.out.println(myMovie);// Printing info

		MovieAction movAction = new MovieAction();// Creating actions obj
		boolean success = movAction.create(myMovie);// Executing operation
		if (success) {// If the operation was succesful
			System.out.println("Movie inserted.");
		} else {
			System.out.println("Movie insertion failed.");
		}

	}

}
