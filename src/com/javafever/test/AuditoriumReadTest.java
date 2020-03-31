package com.javafever.test;

import java.util.List;

import com.javafever.auditorium.Auditorium;
import com.javafever.auditorium.AuditoriumAction;

public class AuditoriumReadTest {

	public static void main(String[] args) {
		AuditoriumAction audAction = new AuditoriumAction();
		List<Auditorium> lstAuditorium = audAction.read();

		System.out.println(lstAuditorium);

	}

}
