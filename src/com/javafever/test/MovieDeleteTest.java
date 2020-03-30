package com.javafever.test;

import com.javafever.movie.Movie;
import com.javafever.movie.MovieAction;

public class MovieDeleteTest {

	public static void main(String[] args) {
		MovieAction movAction = new MovieAction();
		Movie myMovie = new Movie();
		myMovie.setIdMovie(3);

		boolean success = movAction.delete(myMovie);

		if (success) {
			System.out.println("Movie deleted succcesfully");
		} else
			System.out.println("Movie deletion failed.");

	}

}
