package com.javafever.test;

import java.time.LocalDateTime;

import com.javafever.theatreschedule.ScheduleAction;
import com.javafever.theatreschedule.TheatreSchedule;

public class ScheduleUpdateTest {

	public static void main(String[] args) {

		ScheduleAction schAction = new ScheduleAction();

		TheatreSchedule myNewSchedule = new TheatreSchedule();
		myNewSchedule.setIdSchedule(4);
		myNewSchedule.setShowtime(LocalDateTime.now());
		myNewSchedule.setIdAuditorium(1);
		myNewSchedule.setIdMovie(3);
		myNewSchedule.setPrice(10.50f);

		boolean success = schAction.update(myNewSchedule);
		if (success) {
			System.out.println("Schedule updated successfully.");
		} else {
			System.out.println("Schedule updated failed.");
		}

	}

}
