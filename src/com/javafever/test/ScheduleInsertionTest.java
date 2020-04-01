package com.javafever.test;

import java.time.LocalDateTime;

import com.javafever.theatreschedule.ScheduleAction;
import com.javafever.theatreschedule.TheatreSchedule;

public class ScheduleInsertionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheatreSchedule mySchedule = new TheatreSchedule();
		mySchedule.setShowtime(LocalDateTime.now());// Setting values
		mySchedule.setIdAuditorium(1);
		mySchedule.setIdMovie(3);
		mySchedule.setPrice(14.45F);
		mySchedule.setSeat(1);
		System.out.println(mySchedule);// Printing info

		ScheduleAction scheAction = new ScheduleAction();// Creating actions obj
		boolean success = scheAction.create(mySchedule);// Executing operation
		if (success) {// If the operation was succesful
			System.out.println("Schedule inserted.");
		} else {
			System.out.println("Schedule insertion failed.");

		}

	}
}