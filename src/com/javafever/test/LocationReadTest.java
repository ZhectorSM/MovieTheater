package com.javafever.test;

import java.util.List;

import com.javafever.location.Location;
import com.javafever.location.LocationAction;

public class LocationReadTest {

	public static void main(String[] args) {

		LocationAction locAction = new LocationAction();
		List<Location> lstLocation = locAction.read();

		System.out.println(lstLocation);

	}

}
