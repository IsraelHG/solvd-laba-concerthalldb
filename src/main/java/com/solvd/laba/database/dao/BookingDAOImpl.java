package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.*;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * The BookingDAOImpl class is an implementation of the BookingDAO interface that provides
 * methods to interact with the Bookings table in the database using JDBC.
 */
public class BookingDAOImpl extends BaseDAOImpl<Booking> implements BookingDAO {
    private static final String BOOKING_ID = "booking_id";
    private static final String BOOKING_DATE = "booking_date";
    private static final String FK_EVENT_ID = "event_id";
    private static final String FK_AUDIENCE_ID = "audience_id";
    private static final String FK_STAFF_ID = "staff_id";
    private static final String FK_TICKET_ID = "ticket_id";
    private static final String TABLE_NAME = "bookings";

    @Override
    protected Booking mapRow(ResultSet resultSet) throws SQLException {
        Booking booking = new Booking();
        booking.setBookingId(resultSet.getInt(BOOKING_ID));
        // Retrieve the start date as a Timestamp from the ResultSet
        Timestamp timeStamp = resultSet.getTimestamp(BOOKING_DATE);
        if (timeStamp != null) {
            // Convert the Timestamp to LocalDateTime
            LocalDateTime bookingDate = timeStamp.toLocalDateTime();
            booking.setBookingDate(bookingDate);
        }

        //----------------------------------------
        // Retrieves the event id from the booking table, which will then
        // be mapped to its corresponding object, and set it in the booking class.
        int eventId = resultSet.getInt(FK_EVENT_ID);
        Event event = fetchEventForBooking(eventId);
        booking.setEvent(event);

        // Retrieves the audience id from the booking table, which will then
        // be mapped to its corresponding object, and set it in the booking class.
        int audienceId = resultSet.getInt(FK_AUDIENCE_ID);
        Audience audience = fetchAudienceForBooking(audienceId);
        booking.setAudience(audience);

        // Retrieves the staff id from the booking table, which will then
        // be mapped to its corresponding object, and set it in the booking class.
        int staffId = resultSet.getInt(FK_STAFF_ID);
        Staff staff = fetchStaffForBooking(staffId);
        booking.setStaff(staff);

        // Retrieves the ticket id from the booking table, which will then
        // be mapped to its corresponding object, and set it in the booking class.
        int ticketId = resultSet.getInt(FK_TICKET_ID);
        Ticket ticket = fetchTicketForBooking(ticketId);
        booking.setTicket(ticket);
        //--------------------------------------------

        return booking;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected String getIdColumnName() {
        return BOOKING_ID;
    }

    @Override
    protected int getId(Booking entity) {
        return entity.getBookingId();
    }

    @Override
    protected String getInsertValues(Booking entity) {
        return "(" + BOOKING_DATE + ", " + FK_EVENT_ID  + ", " + FK_AUDIENCE_ID  + ", " + FK_STAFF_ID  + ", " + FK_TICKET_ID  + ") VALUES ('" +
                entity.getBookingDate() + "', '" + entity.getEvent().getEventId() + "', '" + entity.getAudience().getAudienceId() + "', '" +
                entity.getStaff().getStaffId() + "', '" + entity.getTicket().getTicketId() + "');";
    }

    @Override
    protected String getUpdateValues(Booking entity) {
        return BOOKING_DATE + "='" + entity.getBookingDate() + "', " +
                FK_EVENT_ID + "='" + entity.getEvent().getEventId() + "', " +
                FK_AUDIENCE_ID + "='" + entity.getAudience().getAudienceId() + "', " +
                FK_STAFF_ID + "='" + entity.getStaff().getStaffId() + "', " +
                FK_TICKET_ID + "='" + entity.getTicket().getTicketId() + "');";
    }

    @Override
    public Event fetchEventForBooking(int eventId) throws SQLException {
        EventDAO eventDAO = new EventDAOImpl();
        return eventDAO.get(eventId);
    }

    @Override
    public Audience fetchAudienceForBooking(int audienceId) throws SQLException {
        AudienceDAO audienceDAO = new AudienceDAOImpl();
        return audienceDAO.get(audienceId);
    }

    @Override
    public Staff fetchStaffForBooking(int staffId) throws SQLException {
        StaffDAO staffDAO = new StaffDAOImpl();
        return staffDAO.get(staffId);
    }

    @Override
    public Ticket fetchTicketForBooking(int ticketId) throws SQLException {
        TicketDAO ticketDAO = new TicketDAOImpl();
        return ticketDAO.get(ticketId);
    }
}
