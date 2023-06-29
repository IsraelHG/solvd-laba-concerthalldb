package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.BookingDAO;
import com.solvd.laba.database.dao.BookingDAOImpl;
import com.solvd.laba.database.interfaces.IBookingService;
import com.solvd.laba.database.model.Booking;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The BookingService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class BookingService implements IBookingService {
    private final BookingDAO bookingDAO;

    public BookingService() {
        this.bookingDAO = new BookingDAOImpl();
    }

    public Booking getBookingById(int bookingId) {
        try {
            return bookingDAO.get(bookingId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Booking getBookingByAudienceId(int id) {
        return null;
    }

    @Override
    public ArrayList<Booking> getBookings() {
        try {
            return bookingDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void setBooking(Booking booking) {
        try {
            bookingDAO.insert(booking);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBooking(Booking booking) {
        try {
            bookingDAO.update(booking);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteBooking(Booking booking) {
        try {
            bookingDAO.delete(booking);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
