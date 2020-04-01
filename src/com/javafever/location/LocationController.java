package com.javafever.location;

import java.util.List;
import java.util.Scanner;

import com.javafever.main.MovieTheatreMain;

public class LocationController {

	public void locationMenu() {
		System.out.println("*Location Menu*");
		System.out.println("1 = create new Location");
		System.out.println("2 = List Locations");
		System.out.println("3 = Update a location");
		System.out.println("4 = Delete a location");
		System.out.println("0 = Go to Admin Menu");
		System.out.println("Choose an option...");

		Scanner input = new Scanner(System.in);
		int userChoice = input.nextInt();

		switch (userChoice) {
		case 1:
			addLocation();
			break;

		case 2:
			listLocation();
			break;

		case 3:
			updateLocation();
			break;

		case 4:
			deleteLocation();
			break;

		case 0:
			MovieTheatreMain.showAdminMenu();
			break;

		default:
			callLocationMenu();
			break;
		}
		input.close();
	}

	public void addLocation() {
		Scanner input = new Scanner(System.in);
		System.out.println("*Add new location");
		System.out.println("Type the location name");

		Location myLocation = new Location();
		myLocation.setLocation(input.nextLine());

		System.out.println("Type the address");
		myLocation.setAddress(input.nextLine());

		LocationAction locAction = new LocationAction();
		boolean success = locAction.create(myLocation);

		if (success) {
			System.out.println("Location inserted.");
		} else {
			System.out.println("Location insertion failed.");
		}

		callLocationMenu();
		input.close();

	}

	public void listLocation() {

		LocationAction locAction = new LocationAction();
		List<Location> lstLocation = locAction.read();
		System.out.println("*List of Location*");
		for (Location loc : lstLocation) {
			System.out.println(loc.getIdLocation() + loc.getLocation() + loc.getAddress());
		}
		callLocationMenu();
	}

	public void updateLocation() {

		LocationAction locAction = new LocationAction();
		Location myNewLocation = new Location();

		List<Location> lstLocation = locAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Update a location*");

		System.out.println("Type a ID of the Location: ");
		int idLocSelected = input.nextInt();

		boolean exists = false;
		for (Location loc : lstLocation) {
			if (loc.getIdLocation() == idLocSelected) {
				exists = true;
			}
		}

		if (!exists) {
			System.out.println("Location does not exist");
			input.close();
			return;
		}

		myNewLocation.setIdLocation(idLocSelected);

		System.out.println("Type the new location name: ");
		myNewLocation.setLocation(input.nextLine());

		System.out.println("Type the new address: ");
		myNewLocation.setAddress(input.nextLine());

		boolean success = locAction.update(myNewLocation);
		if (success) {
			System.out.println("Location updated successfully");
		} else {
			System.out.println("Location updated failed.");
		}

		callLocationMenu();
		input.close();

	}

	public void deleteLocation() {
		LocationAction locAction = new LocationAction();
		Location myLocation = new Location();

		List<Location> lstLocation = locAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Delete a location*");

		System.out.println("Type the ID of location you want to delete");
		int idLocSelected = input.nextInt();

		boolean exists = false;

		for (Location loc : lstLocation) {
			if (loc.getIdLocation() == idLocSelected) {
				exists = true;
				myLocation.setIdLocation(loc.getIdLocation());
			}
		}
		if (!exists) {
			System.out.println("location does not exist");
			input.close();
			return;
		}
		boolean success = locAction.delete(myLocation);

		if (success) {
			System.out.println("Location deleted successfully");
		} else {
			System.out.println("Location deletion failed. ");
		}

		callLocationMenu();
		input.close();

	}

	private void callLocationMenu() {
		System.out.println();
		System.out.println("ENTER to go to menu");
		System.out.println();
		Scanner input = new Scanner(System.in);
		String readString = input.nextLine();

		while (readString != null) {
			System.out.println(readString);

			if (readString.isEmpty()) {
				locationMenu();
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
