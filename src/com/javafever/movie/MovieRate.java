package com.javafever.movie;

public enum MovieRate {

	G("General Audience"), PG("Parental Guidance Suggested"), PG13("Parents Strongly Cautioned"), R("Restricted"),
	NC17("Adults Only");

	private final String value;

	MovieRate(String value) {
		this.value = value;

	}

	public String getvalue() {
		return value;
	}
}
