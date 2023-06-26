package com.solvd.laba.database.interfaces;

import com.solvd.laba.database.model.Booking;

import java.util.ArrayList;


/**
 * The IBookingService interface provides a contract for accessing and manipulating booking data.
 * It defines methods for retrieving, inserting, updating, and deleting booking objects.
 */
public interface IBookingService {
    /**
     * Retrieves a booking with the specified ID.
     *
     * @param id the ID of the booking to retrieve
     * @return the booking object with the specified ID, or null if not found
     */
    Booking getBookingById(int id);

    /**
     * Retrieves a list of all bookings.
     *
     * @return an ArrayList containing all bookings
     */
    ArrayList<Booking> getBookings();

    /**
     * Inserts a new booking into the database.
     *
     * @param booking the booking object to insert
     */
    void setBooking(Booking booking);

    /**
     * Updates an existing booking in the database.
     *
     * @param booking the booking object to update
     */
    void updateBooking(Booking booking);

    /**
     * Deletes a booking from the database.
     *
     * @param booking the booking object to delete
     */
    void deleteBooking(Booking booking);
}
