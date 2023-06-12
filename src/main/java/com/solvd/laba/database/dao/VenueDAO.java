package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.Venue;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The VenuesDAO interface extends the BaseDAO interface and provides specific data access operations for managing
 * venues in the database.
 */
public interface VenueDAO extends BaseDAO<Venue> {
    /**
     * Fetches the venues associated with a specific event.
     *
     * @param eventId The ID of the event for which to fetch the venues.
     * @return An ArrayList of Venues objects representing the venues associated with the event,
     *         or an empty ArrayList if no venues are found.
     * @throws SQLException if a database access error occurs.
     */
    ArrayList<Venue> fetchVenuesForEvent(int eventId) throws SQLException;
}
