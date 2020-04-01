package com.javafever.test;

import com.javafever.auditorium.Auditorium;
import com.javafever.auditorium.AuditoriumAction;

public class AuditoriumDeleteTest {

	public static void main(String[] args) {

		AuditoriumAction audAction = new AuditoriumAction();
		Auditorium myAuditorium = new Auditorium();
		myAuditorium.setIdAuditorium(3);

		boolean success = audAction.delete(myAuditorium);

		if (success) {
			System.out.println("Auditorium deleted successfully");
		} else {
			System.out.println("Auditorium deletion failed.");
		}

	}

}
