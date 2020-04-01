package com.javafever.customer;

import java.util.List;
import java.util.Scanner;

public class CustomerController {

	public void customerMenu() {

		System.out.println("**Customer Menu**");
		System.out.println("1 = Create new customer");
		System.out.println("2 = List Customers");
		System.out.println("3 = Update a Customer");
		System.out.println("4 = Delete a Customer");
		System.out.println("0 = Go to Main Menu");
		System.out.println("Choose an option...");

		Scanner input = new Scanner(System.in);
		int userChoice = input.nextInt();

		switch (userChoice) {
		case 1:
			addCustomer();
			break;
		case 2:
			listCustomers();
			break;
		case 3:
			updateCustomer();
			break;
		case 4:
			deleteCustomer();
			break;
		case 0:

			break;
		default:
			customerMenu();
			break;
		}

		input.close();
	}

	public void listCustomers() {

		CustomerAction catAction = new CustomerAction();
		List<Customer> lstCustomers = catAction.read();
		System.out.println("*List of Custiomers*");
		for (Customer cat : lstCustomers) {
			System.out.println(cat.getIdCustomer() + " " + cat.getFirstName() + cat.getLastName());
		}

		callCustomerMenu();

	}

	public void addCustomer() {
		Scanner input = new Scanner(System.in);
		Customer myCustomer = new Customer();
		System.out.println("*Add new Customer*");
		System.out.println("Type the first name:");
		myCustomer.setFirstName(input.nextLine().trim());
		System.out.println("Type the last name:");
		myCustomer.setLastName(input.nextLine().trim());
		System.out.println("Type the gender:");
		myCustomer.setGender(input.nextLine().trim());
		System.out.println("Type the Email:");
		myCustomer.setEmail(input.nextLine().trim());
		System.out.println("Type the points:");
		myCustomer.setPoints(input.nextInt());
		input.nextLine();
		
		
		CustomerAction catAction = new CustomerAction();// Creating actions obj
		boolean success = catAction.create(myCustomer);// Executing operation
		
		if (success) {// If the operation was succesful
			System.out.println("CastomerName inserted.");
		} else {
			System.out.println("CastomerName insertion failed.");
		}

		callCustomerMenu();
		input.close();
	}

	public void updateCustomer() {

		Customer myNewCustomer= new Customer();
		CustomerAction catAction = new CustomerAction();

		// Get list of categories
		List<Customer> lstCustomers = catAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Update a Castomer*");

		System.out.println("Type the ID of the customer:");
		int idCatSelected = input.nextInt();

		// Looking for the category
		boolean exists = false;
		for (Customer cat : lstCustomers) {
			if (cat.getIdCustomer() == idCatSelected) {
				exists = true;
			}
		}

		if (!exists) {// Id the category does not exist
			System.out.println("Customername does not exist.");
			input.close();
			return; // finish the method execution
		}

		myNewCustomer.setIdCustomer(idCatSelected);
		
		System.out.println("*Add new Customer*");
		System.out.println("Type the first name:");
		myNewCustomer.setFirstName(input.next());
		System.out.println("Type the last name:");
		myNewCustomer.setLastName(input.next());
		System.out.println("Type the gender:");
		myNewCustomer.setGender(input.next());
		System.out.println("Type the Email:");
		myNewCustomer.setEmail(input.next());
		System.out.println("Type the points:");
		myNewCustomer.setPoints(input.nextInt());
		input.nextLine();
		

		
		boolean success = catAction.update(myNewCustomer);

		if (success) {
			System.out.println("Customer updated successfully.");
		} else {
			System.out.println("Customer updated failed.");
		}

		callCustomerMenu();
		input.close();
	}

	public void deleteCustomer() {

		Customer myCustomer = new Customer();
		CustomerAction catAction = new CustomerAction();

		// Get list of categories
		List<Customer> lstCustomers = catAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Delete a customername*");

		System.out.println("Type the ID of the cutomername:");
		int idCatSelected = input.nextInt();

		// Looking for the category
		boolean exists = false;
		for (Customer cat : lstCustomers) {
			if (cat.getIdCustomer() == idCatSelected) {
				exists = true;
				myCustomer.setIdCustomer(cat.getIdCustomer());
			}
		}

		if (!exists) {// Id the category does not exist
			System.out.println("Customername does not exist.");
			input.close();
			return; // finish the method execution
		}

		boolean success = catAction.delete(myCustomer);// delete category

		if (success) {
			System.out.println("Customername deleted succcesfully");
		} else {
			System.out.println("Customername deletion failed.");
		}

		callCustomerMenu();
		input.close();
	}

	public void callCustomerMenu() {
		System.out.println();
		System.out.println("ENTER to go to menu");
		System.out.println();
		Scanner input = new Scanner(System.in);
		String readString = input.nextLine();

		while (readString != null) {
			System.out.println(readString);

			if (readString.isEmpty()) {
				customerMenu();
			}

			if (input.hasNextLine()) {
				readString = input.nextLine();
			} else {
				readString = null;
			}
		}
		input.close();

	}

}