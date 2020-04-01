package com.javafever.test;

import com.javafever.loyalprograms.LoyalPrograms;
import com.javafever.loyalprograms.LoyalProgramAction;

public class LoyalProgramInsertionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			        
		            LoyalPrograms myLoyalPrograms = new LoyalPrograms();
		            myLoyalPrograms.setDiscount(10);
		            myLoyalPrograms.setMinimumPoints(10);
					// Setting values
					System.out.println(myLoyalPrograms);// Printing info

					LoyalProgramAction catAction = new LoyalProgramAction();// Creating actions obj
					boolean success = catAction.create(myLoyalPrograms);// Executing operation

					if (success) {// If the operation was succesful
						System.out.println("Customer inserted.");
					} else {
						System.out.println("Customer insertion failed.");
					}


		}


	}


