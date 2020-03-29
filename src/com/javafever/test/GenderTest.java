package com.javafever.test;

public class GenderTest {

	public static void main(String[] args) {

		Person personOne = new Person();
		personOne.setName("Hector");
		personOne.setGender(Gender.M);

		System.out.println(personOne);

	}

}
