package com.javafever.test;

import java.util.List;

import com.javafever.user.User;
import com.javafever.user.UserAction;

public class UserReadTest {

	public static void main(String[] args) {
		UserAction catAction = new UserAction();
		List<User> lstUser = catAction.read();

		System.out.println(lstUser);

	}

}
