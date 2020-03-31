package com.javafever.test;

import com.javafever.category.Category;
import com.javafever.category.CategoryAction;

public class CategoryUpadateTest {

	public static void main(String[] args) {

		CategoryAction catAction = new CategoryAction();

		Category myNewCategory = new Category();
		myNewCategory.setIdCategory(7);
		myNewCategory.setCategoryName("Horror");

		boolean success = catAction.update(myNewCategory);
		if (success) {
			System.out.println("Category updated successfully.");
		} else {
			System.out.println("Category updated failed.");
		}

	}

}
