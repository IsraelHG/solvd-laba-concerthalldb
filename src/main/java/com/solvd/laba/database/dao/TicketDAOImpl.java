package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The TicketDAOImpl class is an implementation of the TicketDAO interface that provides
 * methods to interact with the Tickets table in the database using JDBC.
 */
public class TicketDAOImpl extends BaseDAOImpl<Ticket> implements TicketDAO {
    private static final String TICKET_ID = "ticket_id";
    private static final String SEAT_NUMBER = "seat_number";
    private static final String TABLE_NUMBER = "Tickets";
    @Override
    protected Ticket mapRow(ResultSet resultSet) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setTicketId(resultSet.getInt(TICKET_ID));
        ticket.setSeatNumber(resultSet.getString(SEAT_NUMBER));
        return ticket;
    }

    @Override
    protected String getTableName() {
        return TABLE_NUMBER;
    }

    @Override
    protected String getIdColumnName() {
        return TICKET_ID;
    }

    @Override
    protected int getId(Ticket entity) {
        return entity.getTicketId();
    }

    @Override
    protected String getInsertValues(Ticket entity) {
        return "(" + SEAT_NUMBER + ") VALUES ('" + entity.getSeatNumber() + "');";
    }

    @Override
    protected String getUpdateValues(Ticket entity) {
        return SEAT_NUMBER + "='" + entity.getSeatNumber() + "'";
    }
}
