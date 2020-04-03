package com.javafever.loyalprograms;

import java.util.List;
import java.util.Scanner;

import com.javafever.main.MovieTheatreMain;

public class LoyalProgramController {

	public void LoyalProgramMenu() {

		System.out.println("**LoyalProgram Menu**");
		System.out.println("1 = Create new LoyalProgram");
		System.out.println("2 = List Loyalty Program");
		System.out.println("3 = Update a LoyaltyProgram");
		System.out.println("4 = Delete a Loyalty Program");
		System.out.println("0 = Go to Admin Menu");
		System.out.println("Choose an option...");

		Scanner input = new Scanner(System.in);
		int userChoice = input.nextInt();

		switch (userChoice) {
		case 1:
			addLoyalProgram();
			break;
		case 2:
			lstLoyalPrograms();
			break;
		case 3:
			updateLoyalProgram();
			break;
		case 4:
			deleteLoyalProgram();
			break;
		case 0:
			MovieTheatreMain.showAdminMenu();
			break;
		default:
			LoyalProgramMenu();
			break;
		}

	}

	public void lstLoyalPrograms() {

		LoyalProgramAction catAction = new LoyalProgramAction();
		List<LoyalPrograms> lstLoyalPrograms = catAction.read();
		System.out.println("*List of Loyalty Programs*");
		for (LoyalPrograms cat : lstLoyalPrograms) {
			System.out.println(cat.getIdLoyalProgram() + " " + cat.getDiscount());
		}

		callLoyalProgramMenu();

	}

	public void addLoyalProgram() {
		Scanner input = new Scanner(System.in);
		LoyalPrograms myLoyalProgram = new LoyalPrograms();
		System.out.println("*Add new Loyalty Program*");
		System.out.println("Type the Discount percent:");
		myLoyalProgram.setDiscount(input.nextFloat());
		input.nextLine();
		System.out.println("Type the Minimum Points:");
		myLoyalProgram.setMinimumPoints(input.nextInt());
		input.nextLine();

		LoyalProgramAction catAction = new LoyalProgramAction();// Creating actions obj
		boolean success = catAction.create(myLoyalProgram);// Executing operation

		if (success) {// If the operation was succesful
			System.out.println("Loyalty Program inserted.");
		} else {
			System.out.println("Loyalty Program insertion failed.");
		}

		callLoyalProgramMenu();

	}

	public void updateLoyalProgram() {

		LoyalPrograms myNewLoyalProgram = new LoyalPrograms();
		LoyalProgramAction catAction = new LoyalProgramAction();

		// Get list of categories
		List<LoyalPrograms> lstLoyalPrograms = catAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Update a Loyalty Program*");

		System.out.println("Type the ID of the Loyalty Program:");
		int idCatSelected = input.nextInt();

		// Looking for the category
		boolean exists = false;
		for (LoyalPrograms cat : lstLoyalPrograms) {
			if (cat.getIdLoyalProgram() == idCatSelected) {
				exists = true;
			}
		}

		if (!exists) {// Id the category does not exist
			System.out.println("Loyalty Program does not exist.");

			LoyalProgramMenu();
		}

		myNewLoyalProgram.setIdLoyalProgram(idCatSelected);

		System.out.println("Type the new Discount percent:");
		myNewLoyalProgram.setDiscount(input.nextFloat());// Setting the new name
		input.nextLine();
		System.out.println("Type the new Minimum Points:");
		myNewLoyalProgram.setMinimumPoints(input.nextInt());
		input.nextLine();

		boolean success = catAction.update(myNewLoyalProgram);

		if (success) {
			System.out.println("Loyalty Program updated successfully.");
		} else {
			System.out.println("Loyalty Program updated failed.");
		}

		callLoyalProgramMenu();

	}

	public void deleteLoyalProgram() {

		LoyalPrograms myLoyalProgram = new LoyalPrograms();
		LoyalProgramAction catAction = new LoyalProgramAction();

		// Get list of categories
		List<LoyalPrograms> lstLoyalPrograms = catAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Delete a Loyalty Program*");

		System.out.println("Type the ID of the Loyalty Program:");
		int idCatSelected = input.nextInt();

		// Looking for the category
		boolean exists = false;
		for (LoyalPrograms cat : lstLoyalPrograms) {
			if (cat.getIdLoyalProgram() == idCatSelected) {
				exists = true;
				myLoyalProgram.setIdLoyalProgram(cat.getIdLoyalProgram());
			}
		}

		if (!exists) {// Id the category does not exist
			System.out.println("Loyalty Program does not exist.");

			LoyalProgramMenu();
		}

		boolean success = catAction.delete(myLoyalProgram);// delete category

		if (success) {
			System.out.println("Loyalty Program deleted succcesfully");
		} else {
			System.out.println("Loyalty Program deletion failed.");
		}

		callLoyalProgramMenu();

	}

	private void callLoyalProgramMenu() {
		System.out.println();
		System.out.println("ENTER to go to menu");
		System.out.println();
		Scanner input = new Scanner(System.in);
		String readString = input.nextLine();

		while (readString != null) {
			System.out.println(readString);

			if (readString.isEmpty()) {
				LoyalProgramMenu();
			}

			if (input.hasNextLine()) {
				readString = input.nextLine();
			} else {
				readString = null;
			}
		}

	}

}