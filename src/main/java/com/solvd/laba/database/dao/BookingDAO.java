package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.*;

import java.sql.SQLException;

/**
 * The BookingDAO interface extends the BaseDAO interface and provides specific data access operations for managing
 * bookings in the database.
 */
public interface BookingDAO extends BaseDAO<Booking> {

    /**
     * Retrieves the event associated with a specific booking.
     *
     * @param eventId The ID of the event.
     * @return The event associated with the booking.
     * @throws SQLException If an error occurs while accessing the database.
     */
    Event fetchEventForBooking(int eventId) throws SQLException;

    /**
     * Retrieves the audience associated with a specific booking.
     *
     * @param audienceId The ID of the audience.
     * @return The audience associated with the booking.
     * @throws SQLException If an error occurs while accessing the database.
     */
    Audience fetchAudienceForBooking(int audienceId) throws SQLException;

    /**
     * Retrieves the staff associated with a specific booking.
     *
     * @param staffId The ID of the staff.
     * @return The staff associated with the booking.
     * @throws SQLException If an error occurs while accessing the database.
     */
    Staff fetchStaffForBooking(int staffId) throws SQLException;

    /**
     * Retrieves the ticket associated with a specific booking.
     *
     * @param ticketId The ID of the ticket.
     * @return The ticket associated with the booking.
     * @throws SQLException If an error occurs while accessing the database.
     */
    Ticket fetchTicketForBooking(int ticketId) throws SQLException;
}
