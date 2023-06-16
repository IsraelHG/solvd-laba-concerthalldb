package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.Event;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The EventsDAO interface extends the BaseDAO interface and provides specific data access operations for managing
 * events in the database.
 */
public interface EventDAO extends BaseDAO<Event> {
    //Event fetchEventForBooking(int bookingId) throws SQLException;
}
