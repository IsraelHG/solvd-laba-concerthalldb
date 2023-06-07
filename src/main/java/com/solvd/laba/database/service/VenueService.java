package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.VenueDAO;
import com.solvd.laba.database.dao.VenueDAOImpl;
import com.solvd.laba.database.model.Venue;

import java.sql.SQLException;

/**
 * The VenueService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class VenueService {
    private final VenueDAO venueDAO;

    public VenueService() {
        venueDAO = new VenueDAOImpl();
    }

    /**
     * Retrieves a venue with the specified ID along with its associated events.
     *
     * @param venueId the ID of the venue to retrieve
     * @return the venue object with the specified ID
     * @throws SQLException if an error occurs while accessing the database
     */
    public Venue getVenue(int venueId) throws SQLException {
        // Retrieve the venue with the specified ID from the database
        return venueDAO.get(venueId);
    }

    /**
     * Sets a venue and inserts it into the database along with its credentials.
     *
     * @param venue venue object to be pushed into the server
     * @throws SQLException if an error occurs while accessing the database
     */
    public void setVenue(Venue venue) throws SQLException {
        venueDAO.insert(venue);
    }

}
