package com.javafever.test;

import java.util.List;

import com.javafever.category.Category;
import com.javafever.category.CategoryAction;

public class CategoryReadTest {

	public static void main(String[] args) {

		CategoryAction catAction = new CategoryAction();
		List<Category> lstCategory = catAction.read();

		System.out.println(lstCategory);

	}

}
