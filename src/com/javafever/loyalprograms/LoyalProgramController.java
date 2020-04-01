package com.javafever.loyalprograms;

import java.util.List;
import java.util.Scanner;

public class LoyalProgramController  {

	public void LoyalProgramMenu() {

		System.out.println("**LoyalProgram Menu**");
		System.out.println("1 = Create new LoyalProgram");
		System.out.println("2 = List LoyalProgram");
		System.out.println("3 = Update a LoyalProgram");
		System.out.println("4 = Delete a LoyalProgram");
		System.out.println("0 = Go to Main Menu");
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

			break;
		default:
			LoyalProgramMenu();
			break;
		}

		input.close();
	}

	public void lstLoyalPrograms() {

		LoyalProgramAction catAction = new LoyalProgramAction();
		List<LoyalPrograms> lstLoyalPrograms = catAction.read();
		System.out.println("*List of LoyalProgram*");
		for (LoyalPrograms cat : lstLoyalPrograms) {
			System.out.println(cat.getIdLoyalProgram() + " " + cat.getDiscount());
		}

		callLoyalProgramMenu();

	}

	public void addLoyalProgram() {
		Scanner input = new Scanner(System.in);
		LoyalPrograms myLoyalProgram = new LoyalPrograms();
		System.out.println("*Add new LoyalProgram*");
		System.out.println("Type the Discount persent:");
		myLoyalProgram.setDiscount(input.nextFloat());
		System.out.println("Type the MinimumPoints:");
		myLoyalProgram.setMinimumPoints(input.nextInt());


		LoyalProgramAction catAction = new LoyalProgramAction();// Creating actions obj
		boolean success = catAction.create(myLoyalProgram);// Executing operation

		if (success) {// If the operation was succesful
			System.out.println("LoyalProgram inserted.");
		} else {
			System.out.println("LoyalProgram insertion failed.");
		}

		callLoyalProgramMenu();
		input.close();
	}

	public void updateLoyalProgram() {

		LoyalPrograms myNewLoyalProgram = new LoyalPrograms();
		LoyalProgramAction catAction = new LoyalProgramAction();

		// Get list of categories
		List<LoyalPrograms> lstLoyalPrograms = catAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Update a LoyalProgram*");

		System.out.println("Type the ID of the LoyalProgram:");
		int idCatSelected = input.nextInt();

		// Looking for the category
		boolean exists = false;
		for (LoyalPrograms cat : lstLoyalPrograms) {
			if (cat.getIdLoyalProgram() == idCatSelected) {
				exists = true;
			}
		}

		if (!exists) {// Id the category does not exist
			System.out.println("LoyalProgram does not exist.");
			input.close();
			return; // finish the method execution
		}

		myNewLoyalProgram.setIdLoyalProgram(idCatSelected);

		System.out.println("Type the new Discount persent:");
		myNewLoyalProgram.setDiscount(input.nextFloat());// Setting the new name
		System.out.println("Type the new MinimumPoints:");
		myNewLoyalProgram.setMinimumPoints(input.nextInt());

		boolean success = catAction.update(myNewLoyalProgram);

		if (success) {
			System.out.println("LoyalProgram updated successfully.");
		} else {
			System.out.println("LoyalProgram updated failed.");
		}

		callLoyalProgramMenu();
		input.close();
	}

	public void deleteLoyalProgram() {

		LoyalPrograms myLoyalProgram = new LoyalPrograms();
		LoyalProgramAction catAction = new LoyalProgramAction();

		// Get list of categories
		List<LoyalPrograms> lstLoyalPrograms = catAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Delete a LoyalProgram*");

		System.out.println("Type the ID of the LoyalProgram:");
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
			System.out.println("LoyalProgram does not exist.");
			input.close();
			return; // finish the method execution
		}

		boolean success = catAction.delete(myLoyalProgram);// delete category

		if (success) {
			System.out.println("LoyalProgram deleted succcesfully");
		} else {
			System.out.println("LoyalProgram deletion failed.");
		}

		callLoyalProgramMenu();
		input.close();
	}

	public void callLoyalProgramMenu() {
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
		input.close();

	}

}