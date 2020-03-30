package com.javafever.test;

import com.javafever.loyalprograms.LoyalPrograms;
import com.javafever.loyalprograms.LoyalProgramAction;

public class LoyalProgramDeleteTest {

	public static void main(String[] args) {
		LoyalProgramAction catAction = new LoyalProgramAction();
		LoyalPrograms myLoyalPrograms = new LoyalPrograms();
		myLoyalPrograms.setIdLoyalProgram(2);

		boolean success = catAction.delete(myLoyalPrograms);

		if (success) {
			System.out.println("Category deleted succcesfully");
		} else
			System.out.println("Category deletion failed.");
	}


}
