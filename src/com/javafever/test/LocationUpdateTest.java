package com.javafever.test;

import com.javafever.location.Location;
import com.javafever.location.LocationAction;

public class LocationUpdateTest {

	public static void main(String[] args) {

		LocationAction locAction = new LocationAction();

		Location myNewLocation = new Location();
		myNewLocation.setIdLocation(1);
		myNewLocation.setLocation("Cineplex");
		myNewLocation.setAddress("Burnaby 3150");

		boolean success = locAction.update(myNewLocation);
		if (success) {
			System.out.println("Location updated successfully");
		} else {
			System.out.println("Location updated failed.");
		}

	}

}
