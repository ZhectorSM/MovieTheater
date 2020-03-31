package com.javafever.test;

import java.util.List;

import com.javafever.customer.Customer;
import com.javafever.customer.CustomerAction;

public class CustomerReadTest {

	public static void main(String[] args) {
		
		
		CustomerAction catAction = new CustomerAction();
		List<Customer> lstCustomer = catAction.read();

		System.out.println(lstCustomer);

	}

}
