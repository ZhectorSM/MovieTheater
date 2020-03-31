package com.javafever.test;

import com.javafever.auditorium.Auditorium;
import com.javafever.auditorium.AuditoriumAction;

public class AuditoriumUpdateTest {

	public static void main(String[] args) {

		AuditoriumAction audAction = new AuditoriumAction();

		Auditorium myNewAuditorium = new Auditorium();
		myNewAuditorium.setIdAuditorium(4);
		myNewAuditorium.setSeatTotal("40");
		myNewAuditorium.setVip(true);

		boolean success = audAction.update(myNewAuditorium);
		if (success) {
			System.out.println("Auditorium updated successfully");
		} else {
			System.out.println("Auditorium updated failed.");
		}

	}

}
