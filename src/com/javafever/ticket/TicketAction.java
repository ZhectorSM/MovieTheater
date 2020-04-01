package com.javafever.ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javafever.connection.DbConector;
import com.javafever.connection.EntityActions;

public class TicketAction extends EntityActions<Ticket> {

	@Override
	public boolean create(Ticket element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ticket> read() {

		List<Ticket> lstTicket = new ArrayList<>();

		try {

			Connection conn = DbConector.getConnection();// Get the connection from the db conector
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ticket");// Prepare
			ResultSet result = ps.executeQuery();// Execute query for select

			while (result.next()) {

				Ticket ticket = new Ticket();// Creating a list
				ticket.setIdTicket(result.getInt(1));// Get the int value of the column 1
				ticket.setIdLoyalProgram(result.getInt(2));
				ticket.setIdCustomer(result.getInt(3));
				ticket.setIdSchedule(result.getInt(4));

				lstTicket.add(ticket);// Add element to the list
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return lstTicket;

	}

	@Override
	public boolean update(Ticket element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Ticket element) {
		// TODO Auto-generated method stub
		return false;
	}

}
