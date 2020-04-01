package com.javafever.test;

import com.javafever.customer.Customer;
import com.javafever.customer.CustomerAction;



public class CustomerUpdateTest {

	public static void main(String[] args) {
		CustomerAction catAction = new CustomerAction();

		Customer myNewCustomer = new Customer();
		myNewCustomer.setIdCustomer(3);
		myNewCustomer.setFirstName("BAN");
		myNewCustomer.setLastName("AKI");
		myNewCustomer.setGender("M");
		myNewCustomer.setEmail("aki@gmail.com");
		myNewCustomer.setPoints(10);

		boolean success = catAction.update(myNewCustomer);
		if (success) {
			System.out.println("Category updated successfully.");
		} else {
			System.out.println("Category updated failed.");
		}
	}

}
