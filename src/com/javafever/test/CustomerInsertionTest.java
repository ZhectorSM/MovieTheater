package com.javafever.test;

import com.javafever.customer.Customer;
import com.javafever.customer.CustomerAction;

public class CustomerInsertionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create category object
		        
	            Customer myCustomer = new Customer();
				myCustomer.setFirstName("hiro");
				myCustomer.setLastName("aki");
				myCustomer.setGender("M");
				myCustomer.setEmail("aki@gmail.com");
				myCustomer.setPoints(10);// Setting values
				System.out.println(myCustomer);// Printing info

				CustomerAction catAction = new CustomerAction();// Creating actions obj
				boolean success = catAction.create(myCustomer);// Executing operation

				if (success) {// If the operation was succesful
					System.out.println("Customer inserted.");
				} else {
					System.out.println("Customer insertion failed.");
				}


	}

}
