package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.BookingDAO;
import com.solvd.laba.database.dao.BookingDAOImpl;
import com.solvd.laba.database.model.Booking;

import java.sql.SQLException;

/**
 * The BookingService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class BookingService {
    private final BookingDAO bookingDAO;

    public BookingService() {
        this.bookingDAO = new BookingDAOImpl();
    }

    /**
     * Retrieves an audience with the specified ID.
     *
     * @param bookingId the ID of the booking to retrieve
     * @return the booking object with the specified ID
     * @throws SQLException if an error occurs while accessing the database
     */
    public Booking getBooking(int bookingId) throws SQLException {
        return bookingDAO.get(bookingId);
    }

    /**
     * Sets a booking and inserts it into the database along with its credentials.
     *
     * @param booking booking object to be pushed into the server
     * @throws SQLException if an error occurs while accessing the database
     */
    public void setBooking(Booking booking) throws SQLException {
        bookingDAO.insert(booking);
    }

    /**
     * Saves a booking object in the database. This method is used for either inserting a new booking or updating an existing one.
     *
     * @param booking the booking object to save
     * @throws SQLException if an error occurs while accessing the database
     */
    public void saveBooking(Booking booking) throws SQLException {
        bookingDAO.save(booking);
    }

    /**
     * Deletes a booking object from the database.
     *
     * @param booking the booking object to delete
     * @throws SQLException if an error occurs while accessing the database
     */
    public void deleteBooking(Booking booking) throws SQLException {
        bookingDAO.delete(booking);
    }
}
