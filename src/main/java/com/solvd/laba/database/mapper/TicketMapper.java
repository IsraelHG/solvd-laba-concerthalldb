package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Ticket;

public interface TicketMapper {
    /**
     * Retrieves ticket from the database based on the provided ID.
     *
     * @param id the ID of the ticket
     * @return the ticket object if found, null otherwise
     */
    Ticket selectTicketById(int id);

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
     * Deletes ticket from the database based on the provided ID.
     *
     * @param id the ID of the ticket to be deleted
     */
    void deleteTicketById(int id);
}
