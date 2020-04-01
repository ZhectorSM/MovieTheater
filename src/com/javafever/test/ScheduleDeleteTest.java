package com.javafever.test;

import com.javafever.theatreschedule.ScheduleAction;
import com.javafever.theatreschedule.TheatreSchedule;

public class ScheduleDeleteTest {

	public static void main(String[] args) {
		ScheduleAction schAction = new ScheduleAction();
		TheatreSchedule mySchedule = new TheatreSchedule();
		mySchedule.setIdSchedule(3);

		boolean success = schAction.delete(mySchedule);

		if (success) {
			System.out.println("Theatre Schedule deleted succcesfully");
		} else
			System.out.println("Theatre Schedule deletion failed.");

	}

}
