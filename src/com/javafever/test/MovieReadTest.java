package com.javafever.test;

import java.util.List;

import com.javafever.movie.Movie;
import com.javafever.movie.MovieAction;

public class MovieReadTest {

	public static void main(String[] args) {

		MovieAction movAction = new MovieAction();
		List<Movie> lstMovie = movAction.read();

		System.out.println(lstMovie);

	}

}
