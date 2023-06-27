package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Booking;

import java.util.ArrayList;

public interface BookingMapper {
    /**
     * Retrieves booking from the database based on the provided ID.
     *
     * @param id the ID of the booking
     * @return the booking object if found, null otherwise
     */
    Booking getBookingById(int id);

    /**
     * Retrieves all bookings from the database.
     *
     * @return a collection of bookings if found, null otherwise
     */
    ArrayList<Booking> getBookings();

    /**
     * Inserts new booking into the database.
     *
     * @param booking the booking object to be inserted
     */
    void insertBooking(Booking booking);

    /**
     * Updates existing booking in the database.
     *
     * @param booking the booking object to be updated
     */
    void updateBooking(Booking booking);

    /**
     * Deletes booking from the database based on the provided booking object.
     *
     * @param booking the object of the booking to be deleted
     */
    void deleteBooking(Booking booking);
}
