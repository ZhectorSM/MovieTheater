package com.javafever.test;

import java.util.List;

import com.javafever.loyalprograms.LoyalPrograms;
import com.javafever.loyalprograms.LoyalProgramAction;


public class LoyalProgramReadTest {

	public static void main(String[] args) {
		
		LoyalProgramAction catAction = new LoyalProgramAction();
		List<LoyalPrograms> lstLoyalPrograms = catAction.read();

		System.out.println(lstLoyalPrograms);


	}

}
