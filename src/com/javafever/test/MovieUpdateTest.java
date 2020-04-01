package com.javafever.test;

import com.javafever.movie.Movie;
import com.javafever.movie.MovieAction;

public class MovieUpdateTest {

	public static void main(String[] args) {
		MovieAction movAction = new MovieAction();

		Movie myNewMovie = new Movie();
		myNewMovie.setIdMovie(3);
		myNewMovie.setMovieName("Horror");
		myNewMovie.setIdCategory(1);
		myNewMovie.setDirector("Pablo Picas");
		myNewMovie.setActor("Pepe el toro");
		myNewMovie.setMovieYear(1999);
		myNewMovie.setRuntimeMinutes(120);
		myNewMovie.setRate("PG");

		boolean success = movAction.update(myNewMovie);
		if (success) {
			System.out.println("Movie updated successfully.");
		} else {
			System.out.println("Movie updated failed.");
		}

	}

}
