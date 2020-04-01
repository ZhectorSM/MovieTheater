package com.javafever.test;

public enum Gender {

	M("Male"), F("Female"), OTHER("Other");

	private String value;

	Gender(String gender) {
		this.value = gender;
	}

	public String getValue() {
		return value;
	}

}
