package com.solvd.laba.database.interfaces;

import com.solvd.laba.database.model.Ticket;

import java.util.ArrayList;


/**
 * The ITicketService interface provides a contract for accessing and manipulating ticket data.
 * It defines methods for retrieving, inserting, updating, and deleting ticket objects.
 */
public interface ITicketService {
    /**
     * Retrieves ticket with the specified ID.
     *
     * @param id the ID of the ticket to retrieve
     * @return the ticket object with the specified ID, or null if not found
     */
    Ticket getTicketById(int id);

    /**
     * Retrieves a list of all tickets.
     *
     * @return an ArrayList containing all tickets
     */
    ArrayList<Ticket> getTickets();

    /**
     * Inserts new ticket into the database.
     *
     * @param ticket the ticket object to insert
     */
    void setTicket(Ticket ticket);

    /**
     * Updates existing ticket in the database.
     *
     * @param ticket the ticket object to update
     */
    void updateTicket(Ticket ticket);

    /**
     * Deletes a ticket from the database.
     *
     * @param ticket the ticket object to delete
     */
    void deleteTicket(Ticket ticket);
}
