package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.TicketDAO;
import com.solvd.laba.database.dao.TicketDAOImpl;
import com.solvd.laba.database.interfaces.ITicketService;
import com.solvd.laba.database.model.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The TicketService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class TicketService implements ITicketService {
    private final TicketDAO ticketDAO;

    public TicketService() {
        this.ticketDAO = new TicketDAOImpl();
    }

    public Ticket getTicketById(int id) {
        try {
            return ticketDAO.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Ticket> getTickets() {
        try {
            return ticketDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setTicket(Ticket ticket) {
        try {
            ticketDAO.insert(ticket);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTicket(Ticket ticket) {
        try {
            ticketDAO.update(ticket);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteTicket(Ticket ticket) {
        try {
            ticketDAO.delete(ticket);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
