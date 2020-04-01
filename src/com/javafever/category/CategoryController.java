package com.javafever.category;

import java.util.List;
import java.util.Scanner;

import com.javafever.main.MovieTheatreMain;

public class CategoryController {

	public void categoryMenu() {

		System.out.println("**Category Menu**");
		System.out.println("1 = Create new Category");
		System.out.println("2 = List Categories");
		System.out.println("3 = Update a Category");
		System.out.println("4 = Delete a Category");
		System.out.println("0 = Go to Admin Menu");
		System.out.println("Choose an option...");

		Scanner input = new Scanner(System.in);
		int userChoice = input.nextInt();

		switch (userChoice) {
		case 1:
			addCategory();
			break;
		case 2:
			listCategories();
			break;
		case 3:
			updateCategory();
			break;
		case 4:
			deleteCategory();
			break;
		case 0:
			MovieTheatreMain.showAdminMenu();
			break;
		default:
			categoryMenu();
			break;
		}

		input.close();
	}

	public void listCategories() {

		CategoryAction catAction = new CategoryAction();
		List<Category> lstCategories = catAction.read();
		System.out.println("*List of Categories*");
		for (Category cat : lstCategories) {
			System.out.println(cat.getIdCategory() + " " + cat.getCategoryName());
		}

		callCategoryMenu();

	}

	public void addCategory() {
		Scanner input = new Scanner(System.in);
		System.out.println("*Add new Category*");
		System.out.println("Type the Category name:");

		Category myCategory = new Category();
		myCategory.setCategoryName(input.nextLine());// Setting values

		CategoryAction catAction = new CategoryAction();// Creating actions obj
		boolean success = catAction.create(myCategory);// Executing operation

		if (success) {// If the operation was succesful
			System.out.println("Category inserted.");
		} else {
			System.out.println("Category insertion failed.");
		}

		callCategoryMenu();
		input.close();
	}

	public void updateCategory() {

		Category myNewCategory = new Category();
		CategoryAction catAction = new CategoryAction();

		// Get list of categories
		List<Category> lstCategories = catAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Update a Category*");

		System.out.println("Type the ID of the Categoy:");
		int idCatSelected = input.nextInt();

		// Looking for the category
		boolean exists = false;
		for (Category cat : lstCategories) {
			if (cat.getIdCategory() == idCatSelected) {
				exists = true;
			}
		}

		if (!exists) {// Id the category does not exist
			System.out.println("Category does not exist.");
			input.close();
			return; // finish the method execution
		}

		myNewCategory.setIdCategory(idCatSelected);

		System.out.println("Type the new Name:");
		myNewCategory.setCategoryName(input.nextLine());// Setting the new name

		boolean success = catAction.update(myNewCategory);

		if (success) {
			System.out.println("Category updated successfully.");
		} else {
			System.out.println("Category updated failed.");
		}

		callCategoryMenu();
		input.close();
	}

	public void deleteCategory() {

		Category myCategory = new Category();
		CategoryAction catAction = new CategoryAction();

		// Get list of categories
		List<Category> lstCategories = catAction.read();

		Scanner input = new Scanner(System.in);
		System.out.println("*Delete a Category*");

		System.out.println("Type the ID of the Categoy:");
		int idCatSelected = input.nextInt();

		// Looking for the category
		boolean exists = false;
		for (Category cat : lstCategories) {
			if (cat.getIdCategory() == idCatSelected) {
				exists = true;
				myCategory.setIdCategory(cat.getIdCategory());
			}
		}

		if (!exists) {// Id the category does not exist
			System.out.println("Category does not exist.");
			input.close();
			return; // finish the method execution
		}

		boolean success = catAction.delete(myCategory);// delete category

		if (success) {
			System.out.println("Category deleted succcesfully");
		} else {
			System.out.println("Category deletion failed.");
		}

		callCategoryMenu();
		input.close();
	}

	public void callCategoryMenu() {
		System.out.println();
		System.out.println("ENTER to go to menu");
		System.out.println();
		Scanner input = new Scanner(System.in);
		String readString = input.nextLine();

		while (readString != null) {
			System.out.println(readString);

			if (readString.isEmpty()) {
				categoryMenu();
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
