package com.javafever.test;

import java.util.List;

import com.javafever.theatreschedule.ScheduleAction;
import com.javafever.theatreschedule.TheatreSchedule;

public class ScheduleReadTest {

	public static void main(String[] args) {

		ScheduleAction schAction = new ScheduleAction();
		List<TheatreSchedule> lstSchedule = schAction.read();

		System.out.println(lstSchedule);

	}

}
