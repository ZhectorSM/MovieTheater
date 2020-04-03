package com.javafever.auditorium;

import java.util.List;
import java.util.Scanner;

import com.javafever.main.MovieTheatreMain;

public class AuditoriumController {

	public void auditoriumMenu() {

		System.out.println("*Auditorium Menu*");
		System.out.println("1 = Create new Auditorium");
		System.out.println("2 = List Auditorium");
		System.out.println("3 = Update an auditorium");
		System.out.println("4 = Delete an auditorium");
		System.out.println("0 = Go to Admin Menu");
		System.out.println("Choose an option...");

		Scanner input = new Scanner(System.in);
		int userChoice = input.nextInt();

		switch (userChoice) {
		case 1:
			addAuditorium();
			break;

		case 2:
			listAuditotium();
			break;

		case 3:
			updateAuditorium();
			break;

		case 4:
			deleteAuditorium();
			break;

		case 0:
			MovieTheatreMain.showAdminMenu();
			break;

		default:
			callAuditoriumMenu();
			break;
		}
		input.close();

	}

	public void addAuditorium() {

		Scanner input = new Scanner(System.in);
		System.out.println("*Add new auditorium");
		System.out.println("Type total seats of the auditorium");

		Auditorium myAuditorium = new Auditorium();
		myAuditorium.setSeatTotal(input.nextInt());
		input.nextLine();

		System.out.println("Type vip or not");
		myAuditorium.setVip(input.nextBoolean());

		System.out.println("Type the ID of Location");
		myAuditorium.setIdLocation(input.nextInt());
		input.nextLine();

		AuditoriumAction audAction = new AuditoriumAction();
		boolean success = audAction.create(myAuditorium);

		if (success) {
			System.out.println("Auditorium inserted.");
		} else {
			System.out.println("Auditorium insertion failed.");
		}

		callAuditoriumMenu();

	}

	public void listAuditotium() {

		AuditoriumAction audAction = new AuditoriumAction();
		List<Auditorium> lstAuditorium = audAction.read();
		System.out.println("*List of Auditorium*");
		for (Auditorium aud : lstAuditorium) {
			System.out.println(
					aud.getIdAuditorium() + " " + aud.getSeatTotal() + " " + aud.isVip() + " " + aud.getIdLocation());
		}
		callAuditoriumMenu();
	}

	public void callAuditoriumMenu() {
		System.out.println();
		System.out.println("ENTER to go to menu");
		System.out.println();
		Scanner input = new Scanner(System.in);
		String readString = input.nextLine().trim();

		while (readString != null) {
			System.out.println(readString);

			if (readString.isEmpty()) {
				auditoriumMenu();
			}

			if (input.hasNextLine()) {
				readString = input.nextLine().trim();
			} else {
				readString = null;
			}
		}

	}

	public void updateAuditorium() {

		AuditoriumAction audAction = new AuditoriumAction();
		Auditorium myNewAuditorium = new Auditorium();

		List<Auditorium> lstAuditorium = audAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Update a auditorium*");

		System.out.println("Type a ID of the Auditorium: ");
		int idAudSelected = input.nextInt();
		input.nextLine();

		boolean exists = false;
		for (Auditorium aud : lstAuditorium) {
			if (aud.getIdAuditorium() == idAudSelected) {
				exists = true;
			}
		}

		if (!exists) {
			System.out.println("Auditorium does not exist");

			auditoriumMenu();
		}

		myNewAuditorium.setIdAuditorium(idAudSelected);

		System.out.println("Type the total seats of the auditorium: ");
		myNewAuditorium.setSeatTotal(input.nextInt());
		input.nextLine();
		System.out.println("true or false about vip: ");
		myNewAuditorium.setVip(input.nextBoolean());

		boolean success = audAction.update(myNewAuditorium);
		if (success) {
			System.out.println("Auditorium updated successfully");
		} else {
			System.out.println("Auditorium updated failed.");
		}

		callAuditoriumMenu();

	}

	public void deleteAuditorium() {
		AuditoriumAction audAction = new AuditoriumAction();
		Auditorium myAuditorium = new Auditorium();

		List<Auditorium> lstAuditorium = audAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Delete an auditorium*");

		System.out.println("Type the ID of auditorium you want to delete");
		int idAudSelected = input.nextInt();
		input.nextLine();

		boolean exists = false;

		for (Auditorium aud : lstAuditorium) {
			if (aud.getIdAuditorium() == idAudSelected) {
				exists = true;
				myAuditorium.setIdAuditorium(aud.getIdAuditorium());
			}
		}
		if (!exists) {
			System.out.println("auditorium does not exist");

			auditoriumMenu();
		}
		boolean success = audAction.delete(myAuditorium);

		if (success) {
			System.out.println("Auditorium deleted successfully");
		} else {
			System.out.println("Auditorium deletion failed. ");
		}

		callAuditoriumMenu();

	}
}
