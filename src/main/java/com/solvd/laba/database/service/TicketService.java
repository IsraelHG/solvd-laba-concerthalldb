package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.TicketDAO;
import com.solvd.laba.database.dao.TicketDAOImpl;
import com.solvd.laba.database.model.Ticket;

import java.sql.SQLException;

/**
 * The TicketService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class TicketService {
    private final TicketDAO ticketDAO;

    public TicketService() {
        this.ticketDAO = new TicketDAOImpl();
    }

    /**
     * Retrieves a ticket with the specified ID.
     *
     * @param ticketId the ID of the ticket to retrieve
     * @return the ticket object with the specified ID
     * @throws SQLException if an error occurs while accessing the database
     */
    public Ticket getTicket(int ticketId) throws SQLException {
        return ticketDAO.get(ticketId);
    }

    /**
     * Sets a ticket and inserts it into the database along with its credentials.
     *
     * @param ticket ticket object to be pushed into the server
     * @throws SQLException if an error occurs while accessing the database
     */
    public void setTicket(Ticket ticket) throws SQLException {
        ticketDAO.insert(ticket);
    }
}
