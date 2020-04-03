package com.javafever.main;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.javafever.auditorium.Auditorium;
import com.javafever.auditorium.AuditoriumAction;
import com.javafever.auditorium.AuditoriumController;
import com.javafever.category.CategoryController;
import com.javafever.customer.CustomerController;
import com.javafever.location.LocationController;
import com.javafever.loyalprograms.LoyalProgramController;
import com.javafever.movie.Movie;
import com.javafever.movie.MovieAction;
import com.javafever.movie.MovieController;
import com.javafever.theatreschedule.ScheduleController;
import com.javafever.ticket.MovieFunction;
import com.javafever.ticket.Ticket;
import com.javafever.ticket.TicketAction;
import com.javafever.user.User;
import com.javafever.user.UserAction;

public class MovieTheatreMain {

	private static final int CUSTOMER_DEFAULT = 7;

	public static void main(String[] args) {

		showHeader();
		showMainMenu();

	}

	public static void showMainMenu() {
		System.out.println("1 Buy a Ticket");
		System.out.println("2 Log In as Admin");
		System.out.println("0 Exit");

		System.out.println("Choose an option...");
		Scanner input = new Scanner(System.in);
		int userChoice = input.nextInt();
		input.nextLine();
		switch (userChoice) {

		case 1:
			buyTicket();
			break;
		case 2:
			login();
			break;
		case 0:
			System.out.println("See you later!");
			System.exit(0);
			break;
		default:
			showMainMenu();
			break;
		}

		input.close();
	}

	public static void login() {

		Scanner input = new Scanner(System.in);
		System.out.println("Type your user name ");
		User user = new User();
		user.setName(input.nextLine().trim());
		System.out.println("Type your password");
		user.setPwd(input.nextLine().trim());

		// Get users of the database
		UserAction catAction = new UserAction();
		List<User> lstUser = catAction.read();

		// If the user exist on the list
		if (lstUser.contains(user)) {

			String userRole = "";
			for (User usr : lstUser) {// Gettirng the rol of the user

				if (usr.equals(user)) {
					userRole = usr.getRole();
				}
			}

			// Show custom menu
			if (userRole.contentEquals("admin")) {
				showAdminMenu();
			} else {
				showUserMenu();
			}

		} else {
			System.out.println("Verify your data.");
		}

		input.close();
	}

	public static void showAdminMenu() {
		System.out.println(">> Admin Menu <<");
		System.out.println("1 Category");
		System.out.println("2 Movie");
		System.out.println("3 Location");
		System.out.println("4 Auditorium");
		System.out.println("5 Customer");
		System.out.println("6 Schedule");
		System.out.println("7 Loyalty program");
		System.out.println("0 Go to main menu");
		System.out.println("Choose an option...");

		Scanner input = new Scanner(System.in);
		int adminChoice = input.nextInt();
		input.nextLine();
		switch (adminChoice) {
		case 1:
			CategoryController catControl = new CategoryController();
			catControl.categoryMenu();
			break;
		case 2:
			MovieController movieControl = new MovieController();
			movieControl.movieMenu();
			break;
		case 3:
			LocationController locContol = new LocationController();
			locContol.locationMenu();
			break;

		case 4:
			AuditoriumController audContol = new AuditoriumController();
			audContol.auditoriumMenu();
			break;
		case 5:
			CustomerController cusControl = new CustomerController();
			cusControl.customerMenu();
			break;

		case 6:
			ScheduleController schControl = new ScheduleController();
			schControl.scheduleMenu();
			break;

		case 7:
			LoyalProgramController loyalControl = new LoyalProgramController();
			loyalControl.LoyalProgramMenu();
			break;
		case 0:
			showMainMenu();
			break;
		default:
			showAdminMenu();
			break;
		}

		input.close();

	}

	public static void showUserMenu() {

		System.out.println(">> User Menu <<");
		System.out.println("1 List my Tickets");
		System.out.println("2 Buy Ticket");
		System.out.println("3 Update Ticket");
		System.out.println("4 Check my Tickets");
		System.out.println("0 Go to main menu");
		System.out.println("Choose an option...");

		Scanner input = new Scanner(System.in);
		int userChoice = input.nextInt();
		input.nextLine();
		switch (userChoice) {
		case 1:
			break;
		case 2:
			buyTicket();
			break;
		case 3:
			showMainMenu();
			break;

		default:
			showUserMenu();
			break;
		}

		input.close();

	}

	public static void buyTicket() {

		Ticket myTicket = new Ticket();
		myTicket.setIdCustomer(CUSTOMER_DEFAULT);
		myTicket.setIdMovie(chooseMovie());
		myTicket.setIdSchedule(chooseSchedule(myTicket));
		myTicket.setSeat(chooseSeat(myTicket));

		TicketAction tkAction = new TicketAction();
		boolean success = tkAction.create(myTicket);

		if (success) {

			showTicket(myTicket);
			System.out.println("Do you want to buy another Ticket ?  1 = Yes 2 = No");
			Scanner input = new Scanner(System.in);
			int userAnswer = input.nextInt();
			input.nextLine();

			if (userAnswer == 1) {
				buyTicket();
			} else {
				System.out.println("Thank you for your preference.");
				System.exit(0);
			}

		} else {
			System.out.println("Ticket insertion failed");
		}

	}

	public static int chooseMovie() {

		System.out.println("- Movies -");
		MovieAction movAct = new MovieAction();
		List<Movie> lstMovies = movAct.read();
		for (Movie movie : lstMovies) {
			System.out.println(movie.getIdMovie() + " " + movie.getMovieName());
		}

		Scanner input = new Scanner(System.in);
		System.out.println("Choose a Movie (Type the Id):");
		int userIdMovie = input.nextInt();
		input.nextLine();

		// verifing the id of the movie exist
		boolean movieExist = false;
		for (Movie movie : lstMovies) {
			if (userIdMovie == movie.getIdMovie()) {
				movieExist = true;
				break;
			}
		}
		// Set movie
		if (!movieExist) {
			userIdMovie = chooseMovie();
		}

		return userIdMovie;

	}

	public static int chooseSchedule(Ticket myTicket) {

		Scanner input = new Scanner(System.in);

		// Getting available schedule
		TicketAction tkAction = new TicketAction();
		List<MovieFunction> lstFunctions = tkAction.getMovieFuntions(myTicket.getIdMovie());
		System.out.println("- Functions -  ");

		System.out.println("        SHOWTIME                VIP     PRICE   LOC ADDRES  ");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
		for (MovieFunction fun : lstFunctions) {
			System.out.println(fun.getIdSchedule() + "\t" + fun.getShowtime().format(formatter) + "\t"
					+ (fun.isVip() ? "Yes" : "No") + "\t" + fun.getPrice() + "\t" + fun.getAddress());
		}

		System.out.println("Choose the Date (Type the Id):");
		int userIdSchedule = input.nextInt();
		input.nextLine();

		// verifing the id of the schedule exist
		boolean scheduleExist = false;
		for (MovieFunction sch : lstFunctions) {
			if (userIdSchedule == sch.getIdSchedule()) {
				scheduleExist = true;
				break;
			}
		}

		// Set schedule
		if (!scheduleExist) {
			System.out.println("Function does not exist");
			userIdSchedule = chooseSchedule(myTicket);
		}

		return userIdSchedule;

	}

	public static int chooseSeat(Ticket myTicket) {

		Scanner input = new Scanner(System.in);

		int idAuditorium = 0;
		TicketAction tkAction = new TicketAction();
		List<MovieFunction> lstFunctions = tkAction.getMovieFuntions(myTicket.getIdMovie());
		for (MovieFunction fun : lstFunctions) {
			if (myTicket.getIdSchedule() == fun.getIdSchedule()) {
				idAuditorium = fun.getIdAuditorium();
			}
		}

		AuditoriumAction audActAction = new AuditoriumAction();
		List<Auditorium> lstAuditoriums = audActAction.read();
		int totalSeats = 0;
		for (Auditorium aud : lstAuditoriums) {
			if (idAuditorium == aud.getIdAuditorium()) {
				totalSeats = aud.getSeatTotal();
			}
		}

		// Asking for a valid seat
		int seatNum = 0;
		while (seatNum <= 0 || seatNum > totalSeats) {

			System.out.println("Choose a seat...");
			seatNum = input.nextInt();
			input.nextLine();

		}

		// Get tickest already sold
		List<Ticket> lstTicketsSold = tkAction.readBySchedule(myTicket.getIdSchedule());

		boolean seatAvailable = true;
		for (Ticket tk : lstTicketsSold) {
			if (seatNum == tk.getSeat()) {
				seatAvailable = false;
			}
		}

		if (!seatAvailable) {
			System.out.println("Seat no available");
			seatNum = chooseSeat(myTicket);
		}

		return seatNum;

	}

	public static void showTicket(Ticket myTicket) {
		System.out.println("..........Ticket...............");
		System.out.println("Movie:" + myTicket.getIdMovie());
		System.out.println("Seat" + myTicket.getSeat());

		System.out.println(".................................");

	}

	public static void showHeader() {
		System.out.println("*******************************");
		System.out.println("**      JAVA FEVER THEATRE   **");
		System.out.println("**           WELCOME         **");
		System.out.println("**                           **");
		System.out.println("*******************************");
	}

}
