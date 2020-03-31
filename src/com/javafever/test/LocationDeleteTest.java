package com.javafever.test;

import com.javafever.location.Location;
import com.javafever.location.LocationAction;

public class LocationDeleteTest {

	public static void main(String[] args) {

		LocationAction locAction = new LocationAction();
		Location myLocation = new Location();
		myLocation.setIdLocation(8);

		boolean success = locAction.delete(myLocation);

		if (success) {
			System.out.println("Location deleted successfully");
		} else
			System.out.println("Location deletion failed.");

	}

}
