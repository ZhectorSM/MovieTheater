package com.javafever.test;

import java.util.List;

import com.javafever.movie.Movie;
import com.javafever.movie.MovieAction;
import com.javafever.theatreschedule.ScheduleAction;
import com.javafever.theatreschedule.TheatreSchedule;

public class ScheduleReadTest {

	public static void main(String[] args) {

		ScheduleAction schAction = new ScheduleAction();
		List<TheatreSchedule> lstSchedule = schAction.read();

		MovieAction movieAction = new MovieAction();
		List<Movie> lstMovies = movieAction.read();

//		for (Movie movie : lstMovies) {
//			System.out.println(movie);
//		}

		for (TheatreSchedule sched : lstSchedule) {

			String movieName = "";
			for (Movie movie : lstMovies) {
				if (movie.getIdMovie() == sched.getIdMovie()) {
					movieName = movie.getMovieName();
				}
			}

			System.out.println("Movie: " + movieName);

		}

	}

}
