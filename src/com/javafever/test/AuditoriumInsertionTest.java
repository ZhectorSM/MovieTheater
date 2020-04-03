package com.javafever.test;

import com.javafever.auditorium.Auditorium;
import com.javafever.auditorium.AuditoriumAction;;

public class AuditoriumInsertionTest {

	public static void main(String[] args) {

		Auditorium myAuditorium = new Auditorium();
		myAuditorium.setSeatTotal(50);
		myAuditorium.setVip(true);
		myAuditorium.setIdLocation(5);
		System.out.println(myAuditorium);

		AuditoriumAction audAction = new AuditoriumAction();
		boolean success = audAction.create(myAuditorium);

		if (success) {
			System.out.println("Auditorium inserted.");
		} else {
			System.out.println("Auditorium insertion failed.");
		}

	}

}
