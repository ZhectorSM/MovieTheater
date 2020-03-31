package com.javafever.test;

import com.javafever.customer.Customer;
import com.javafever.customer.CustomerAction;

public class CustomerDeleteTest {

	public static void main(String[] args) {
		CustomerAction catAction = new CustomerAction();
		Customer myCustomer = new Customer();
		myCustomer.setIdCustomer(1);

		boolean success = catAction.delete(myCustomer);

		if (success) {
			System.out.println("Category deleted succcesfully");
		} else
			System.out.println("Category deletion failed.");
	}

}
