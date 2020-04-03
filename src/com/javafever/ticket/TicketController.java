package com.javafever.ticket;

import java.util.List;

public class TicketController {

	public void lisTickets() {

		TicketAction tkAction = new TicketAction();
		List<Ticket> lstTicktes = tkAction.read();
		System.out.println("*My Tickets*");
		for (Ticket tk : lstTicktes) {
			System.out.println(tk.getIdTicket() + " " + tk.getIdSchedule() + " " + tk.getIdCustomer());
		}

	}

	public void addTicket(Ticket myTicket) {

		TicketAction tkAction = new TicketAction();// Creating actions obj
		boolean success = tkAction.create(myTicket);// Executing operation

		if (success) {// If the operation was succesful
			System.out.println("Ticket inserted.");
		} else {
			System.out.println("Ticket insertion failed.");
		}

	}

}
