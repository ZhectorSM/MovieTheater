package com.javafever.test;

import com.javafever.category.Category;
import com.javafever.category.CategoryAction;

public class CategoryInsertionTest {

	public static void main(String[] args) {

		// Create category object
		Category myCategory = new Category();
		myCategory.setCategoryName("Romance");// Setting values
		System.out.println(myCategory);// Printing info

		CategoryAction catAction = new CategoryAction();// Creating actions obj
		boolean success = catAction.create(myCategory);// Executing operation

		if (success) {// If the operation was succesful
			System.out.println("Category inserted.");
		} else {
			System.out.println("Category insertion failed.");
		}

	}

}
