package com.javafever.test;

import com.javafever.category.Category;
import com.javafever.category.CategoryAction;

public class CategoryDeleteTest {

	public static void main(String[] args) {

		CategoryAction catAction = new CategoryAction();
		Category myCategory = new Category();
		myCategory.setIdCategory(2);

		boolean success = catAction.delete(myCategory);

		if (success) {
			System.out.println("Category deleted succcesfully");
		} else
			System.out.println("Category deletion failed.");

	}

}
