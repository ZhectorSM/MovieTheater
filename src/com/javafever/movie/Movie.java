package com.javafever.movie;

public class Movie {

	private int idMovie;
	private String movieName;
	private int idCategory;
	private String director;
	private String actor;
	private int movieYear;
	private int runtimeMinutes;
	private String rate;

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public int getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}

	public int getRuntimeMinutes() {
		return runtimeMinutes;
	}

	public void setRuntimeMinutes(int runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actor == null) ? 0 : actor.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + idCategory;
		result = prime * result + idMovie;
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + movieYear;
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + runtimeMinutes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (actor == null) {
			if (other.actor != null)
				return false;
		} else if (!actor.equals(other.actor))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (idCategory != other.idCategory)
			return false;
		if (idMovie != other.idMovie)
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (movieYear != other.movieYear)
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (runtimeMinutes != other.runtimeMinutes)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [idMovie=" + idMovie + ", movieName=" + movieName + ", idCategory=" + idCategory + ", director="
				+ director + ", actor=" + actor + ", movieYear=" + movieYear + ", runtimeMinutes=" + runtimeMinutes
				+ ", rate=" + rate + "]";
	}

}