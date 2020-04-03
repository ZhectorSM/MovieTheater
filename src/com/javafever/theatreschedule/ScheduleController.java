package com.javafever.theatreschedule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.javafever.main.MovieTheatreMain;

public class ScheduleController {

	public void scheduleMenu() {

		System.out.println("**Schedule Menu**");
		System.out.println("1 = Create new Schedule");
		System.out.println("2 = List Schedules");
		System.out.println("3 = Update a Schedule");
		System.out.println("4 = Delete a Schedule");
		System.out.println("0 = Go to Main Menu");
		System.out.println("Choose an option...");

		Scanner input = new Scanner(System.in);
		int userChoice = input.nextInt();

		switch (userChoice) {
		case 1:
			addSchedule();
			break;
		case 2:
			listSchedule();
			break;
		case 3:
			updateSchedule();
			break;
		case 4:
			deleteSchedule();
			break;
		case 0:
			MovieTheatreMain.showAdminMenu();
			break;
		default:
			scheduleMenu();
			break;
		}

		input.close();

	}

	public void listSchedule() {

		ScheduleAction schAction = new ScheduleAction();
		List<TheatreSchedule> lstSchedule = schAction.read();
		System.out.println("*List of Schedule*");
		for (TheatreSchedule sch : lstSchedule) {
			System.out.println(sch.getIdSchedule() + " " + sch.getShowtime() + " " + sch.getIdAuditorium() + " "
					+ sch.getIdMovie() + " " + sch.getPrice());
		}

		callScheduleMenu();
	}

	public void addSchedule() {

		Scanner input = new Scanner(System.in);
		System.out.println("*Add new Schedule*");

		TheatreSchedule mySchedule = new TheatreSchedule();
		// Setting values
		System.out.println("Type the showtime: yyyy-MM-dd'T'HH:mm:ss");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		String userdate = input.nextLine().trim();
		input.nextLine();
		LocalDateTime ldt = LocalDateTime.parse(userdate, formatter);
		mySchedule.setShowtime(ldt);
		System.out.println("Type the Id Auditorium:");
		mySchedule.setIdAuditorium(input.nextInt());
		input.nextLine();
		System.out.println("Type the Id Movie:");
		mySchedule.setIdMovie(input.nextInt());
		input.nextLine();
		System.out.println("Type the new Price:");
		mySchedule.setPrice(input.nextFloat());
		input.nextLine();

		ScheduleAction schAction = new ScheduleAction();// Creating actions obj
		boolean success = schAction.create(mySchedule);// Executing operation

		if (success) {// If the operation was succesful
			System.out.println("Schedule inserted.");
		} else {
			System.out.println("Schedule insertion failed.");
		}

		callScheduleMenu();
		input.close();
	}

	public void updateSchedule() {

		TheatreSchedule myNewSchedule = new TheatreSchedule();
		ScheduleAction schAction = new ScheduleAction();

		// Get list of schedules
		List<TheatreSchedule> lstSchedules = schAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Update a Schedule*");

		System.out.println("Type the ID of the Schedule:");
		int idSchSelected = input.nextInt();
		input.nextLine();
		// Looking for the schedules
		boolean exists = false;
		for (TheatreSchedule sch : lstSchedules) {
			if (sch.getIdSchedule() == idSchSelected) {
				exists = true;
			}
		}

		if (!exists) {// Id the schedules does not exist
			System.out.println("Schedule does not exist.");
			input.close();
			return; // finish the method execution
		}

		myNewSchedule.setIdSchedule(idSchSelected);
		// Setting the new information
		System.out.println("Type the showtime: yyyy-MM-dd'T'HH:mm:ss");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		String userdate1 = input.nextLine().trim();
		input.nextLine();
		LocalDateTime ldt1 = LocalDateTime.parse(userdate1, formatter);
		myNewSchedule.setShowtime(ldt1);
		System.out.println("Type the new Id Category:");
		myNewSchedule.setIdAuditorium(input.nextInt());
		input.nextLine();
		System.out.println("Type the new Id Movie:");
		myNewSchedule.setIdMovie(input.nextInt());
		input.nextLine();
		System.out.println("Type the new Price:");
		myNewSchedule.setPrice(input.nextFloat());
		input.nextLine();

		boolean success = schAction.update(myNewSchedule);

		if (success) {
			System.out.println("Schedule updated successfully.");
		} else {
			System.out.println("Schedule updated failed.");
		}

		callScheduleMenu();
		input.close();

	}

	public void deleteSchedule() {

		TheatreSchedule mySchedule = new TheatreSchedule();
		ScheduleAction schAction = new ScheduleAction();

		// Get list of schedules
		List<TheatreSchedule> lstSchedules = schAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Delete a Schedule*");

		System.out.println("Type the ID of the Schedule:");
		int idSchSelected = input.nextInt();
		input.nextLine();

		// Looking for the schedules
		boolean exists = false;
		for (TheatreSchedule sch : lstSchedules) {
			if (sch.getIdSchedule() == idSchSelected) {
				exists = true;
				mySchedule.setIdSchedule(sch.getIdSchedule());
			}
		}

		if (!exists) {// Id the schedules does not exist
			System.out.println("Schedule does not exist.");
			input.close();
			return; // finish the method execution
		}

		boolean success = schAction.delete(mySchedule);// delete schedules

		if (success) {
			System.out.println("Schedule deleted succcesfully");
		} else {
			System.out.println("Schedule deletion failed.");
		}

		callScheduleMenu();
		input.close();
	}

	private void callScheduleMenu() {
		System.out.println();
		System.out.println("ENTER to go to menu");
		System.out.println();
		Scanner input = new Scanner(System.in);
		String readString = input.nextLine().trim();
		input.nextLine();
		while (readString != null) {
			System.out.println(readString);

			if (readString.isEmpty()) {
				scheduleMenu();
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