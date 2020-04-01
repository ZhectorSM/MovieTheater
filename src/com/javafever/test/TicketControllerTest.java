package com.javafever.test;

import java.util.List;

import com.javafever.ticket.Ticket;
import com.javafever.ticket.TicketAction;

public class TicketControllerTest {

	public static void main(String[] args) {

		TicketAction tkAction = new TicketAction();
		List<Ticket> lstTickets = tkAction.read();

		System.out.println(lstTickets);
	}

}
