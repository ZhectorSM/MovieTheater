package com.javafever.test;

import com.javafever.loyalprograms.LoyalPrograms;
import com.javafever.loyalprograms.LoyalProgramAction;

public class LoyalProgramUpdateTest {

	public static void main(String[] args) {
		LoyalProgramAction catAction = new LoyalProgramAction();

		LoyalPrograms myNewLoyalProgram = new LoyalPrograms();
		myNewLoyalProgram.setIdLoyalProgram(0);
		myNewLoyalProgram.setDiscount(50);
		myNewLoyalProgram.setMinimumPoints(10);
		

		boolean success = catAction.update(myNewLoyalProgram);
		if (success) {
			System.out.println("Category updated successfully.");
		} else {
			System.out.println("Category updated failed.");
		}

	}

}
