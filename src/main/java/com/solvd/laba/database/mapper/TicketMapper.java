package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Ticket;

import java.util.ArrayList;

public interface TicketMapper {
    /**
     * Retrieves ticket from the database based on the provided ID.
     *
     * @param id the ID of the ticket
     * @return the ticket object if found, null otherwise
     */
    Ticket getTicketById(int id);

    ArrayList<Ticket> getTickets();

    /**
     * Inserts new ticket into the database.
     *
     * @param ticket the ticket object to be inserted
     */
    void insertTicket(Ticket ticket);

    /**
     * Updates existing ticket in the database.
     *
     * @param ticket the ticket object to be updated
     */
    void updateTicket(Ticket ticket);

    /**
     * Deletes ticket from the database based on the provided ticket object.
     *
     * @param ticket the object of the ticket to be deleted
     */
    void deleteTicket(Ticket ticket);
}
