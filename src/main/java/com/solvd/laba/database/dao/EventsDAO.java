package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.Events;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The EventsDAO interface extends the BaseDAO interface and provides specific data access operations for managing
 * events in the database.
 */
public interface EventsDAO extends BaseDAO<Events> {
    /**
     * Fetches the events associated with a specific venue.
     *
     * @param venueId The ID of the venue for which to fetch the events.
     * @return An ArrayList of Events objects representing the events associated with the venue,
     *         or an empty ArrayList if no events are found.
     * @throws SQLException if a database access error occurs.
     */
    ArrayList<Events> fetchEventsForVenue(int venueId);

}
