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

}
