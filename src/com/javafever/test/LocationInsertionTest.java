package com.javafever.test;

import com.javafever.location.Location;
import com.javafever.location.LocationAction;

public class LocationInsertionTest {

	public static void main(String[] args) {
		Location myLocation = new Location();
		myLocation.setLocation("Cineplex");
		myLocation.setAddress("88 W Pender St, Vancouver, BC");
		System.out.println(myLocation);

		LocationAction locAction = new LocationAction();
		boolean success = locAction.create(myLocation);

		if (success) {
			System.out.println("Location inserted.");
		} else {
			System.out.println("Location insertion failed.");
		}

	}

}
