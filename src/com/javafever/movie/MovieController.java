package com.javafever.movie;

import java.util.List;
import java.util.Scanner;

public class MovieController {

	public void movieMenu() {

		System.out.println("**Category Menu**");
		System.out.println("1 = Create new Movie");
		System.out.println("2 = List Movies");
		System.out.println("3 = Update a Movie");
		System.out.println("4 = Delete a Movie");
		System.out.println("0 = Go to Main Menu");
		System.out.println("Choose an option...");

		Scanner input = new Scanner(System.in);
		int userChoice = input.nextInt();

		switch (userChoice) {
		case 1:
			addMovie();
			break;
		case 2:
			listMovie();
			break;
		case 3:
			updateMovie();
			break;
		case 4:
			deleteMovie();
			break;
		case 0:

			break;
		default:
			movieMenu();
			break;
		}

		input.close();
	}

	public void listMovie() {

		MovieAction schAction = new MovieAction();
		List<Movie> lstMovies = schAction.read();
		System.out.println("*List of Movies*");
		for (Movie mov : lstMovies) {
			System.out.println(mov.getIdMovie() + " " + mov.getMovieName() + " " + mov.getIdCategory() + " "
					+ mov.getDirector() + " " + mov.getActor() + " " + mov.getMovieYear() + " "
					+ mov.getRuntimeMinutes() + " " + mov.getRate());
		}

		callMovieMenu();

	}

	public void addMovie() {

		Scanner input = new Scanner(System.in);
		System.out.println("*Add new Movie*");
		// System.out.println("Type the Movie name:");
		// System.out.println("Type the Id Category:");
		// System.out.println("Type the Director:");
		// System.out.println("Type the Actor:");
		// System.out.println("Type the Movie Year:");
		// System.out.println("Type the Runtime Minutes:");
		// System.out.println("Type the Rate:");

		Movie myMovie = new Movie();
		System.out.println("Type the Movie name:");
		myMovie.setMovieName(input.next());// Setting values
		System.out.println("Type the Id Category:");
		myMovie.setIdCategory(input.nextInt());
		System.out.println("Type the Director:");
		myMovie.setDirector(input.next());
		System.out.println("Type the Actor:");
		myMovie.setActor(input.next());
		System.out.println("Type the Movie Year:");
		myMovie.setMovieYear(input.nextInt());
		System.out.println("Type the Runtime Minutes:");
		myMovie.setRuntimeMinutes(input.nextInt());
		System.out.println("Type the Rate:");
		myMovie.setRate(input.next());

		MovieAction movAction = new MovieAction();// Creating actions obj
		boolean success = movAction.create(myMovie);// Executing operation

		if (success) {// If the operation was succesful
			System.out.println("Movie inserted.");
		} else {
			System.out.println("Movie insertion failed.");
		}

		callMovieMenu();
		input.close();
	}

	public void updateMovie() {

		Movie myNewMovie = new Movie();
		MovieAction movAction = new MovieAction();

		// Get list of categories
		List<Movie> lstMovies = movAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Update a Movie*");

		System.out.println("Type the ID of the Movie:");
		int idMovSelected = input.nextInt();

		// Looking for the category
		boolean exists = false;
		for (Movie mov : lstMovies) {
			if (mov.getIdMovie() == idMovSelected) {
				exists = true;
			}
		}

		if (!exists) {// Id the category does not exist
			System.out.println("Movie does not exist.");
			input.close();
			return; // finish the method execution
		}

		myNewMovie.setIdMovie(idMovSelected);

		System.out.println("Type the new Name:");
		myNewMovie.setMovieName(input.next());// Setting the new name
		System.out.println("Type the new Id Category:");
		myNewMovie.setIdCategory(input.nextInt());
		System.out.println("Type the new Director:");
		myNewMovie.setDirector(input.next());
		System.out.println("Type the new Actor:");
		myNewMovie.setActor(input.next());
		System.out.println("Type the new Movie Year:");
		myNewMovie.setMovieYear(input.nextInt());
		System.out.println("Type the new Runtime Minutes:");
		myNewMovie.setRuntimeMinutes(input.nextInt());
		System.out.println("Type the new Rate:");
		myNewMovie.setRate(input.next());

		boolean success = movAction.update(myNewMovie);

		if (success) {
			System.out.println("Movie updated successfully.");
		} else {
			System.out.println("Movie updated failed.");
		}

		callMovieMenu();
		input.close();

	}

	public void deleteMovie() {

		Movie myMovie = new Movie();
		MovieAction movAction = new MovieAction();

		// Get list of categories
		List<Movie> lstMovies = movAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Delete a Movie*");

		System.out.println("Type the ID of the Movie:");
		int idMovSelected = input.nextInt();

		// Looking for the category
		boolean exists = false;
		for (Movie mov : lstMovies) {
			if (mov.getIdMovie() == idMovSelected) {
				exists = true;
				myMovie.setIdMovie(mov.getIdMovie());
			}
		}

		if (!exists) {// Id the category does not exist
			System.out.println("Movie does not exist.");
			input.close();
			return; // finish the method execution
		}

		boolean success = movAction.delete(myMovie);// delete category

		if (success) {
			System.out.println("Movie deleted succcesfully");
		} else {
			System.out.println("Movie deletion failed.");
		}

		callMovieMenu();
		input.close();
	}

	public void callMovieMenu() {
		System.out.println();
		System.out.println("ENTER to go to menu");
		System.out.println();
		Scanner input = new Scanner(System.in);
		String readString = input.nextLine();

		while (readString != null) {
			System.out.println(readString);

			if (readString.isEmpty()) {
				movieMenu();
			}

			if (input.hasNextLine()) {
				readString = input.nextLine();
			} else {
				readString = null;
			}
		}
		input.close();
	}
}