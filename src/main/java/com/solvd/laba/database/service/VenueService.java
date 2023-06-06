package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.VenueDAO;
import com.solvd.laba.database.dao.VenueDAOImpl;
import com.solvd.laba.database.model.Venue;

import java.sql.SQLException;

public class VenueService {
    /**
     * Retrieves a venue with the specified ID along with its associated events.
     *
     * @param venueId the ID of the venue to retrieve
     * @return the venue object with the specified ID, including its associated events
     * @throws SQLException if an error occurs while accessing the database
     */
    public Venue getVenue(int venueId) throws SQLException {
        VenueDAO venuesDAO = new VenueDAOImpl();

        // Retrieve the venue with the specified ID from the database
        return venuesDAO.get(venueId);
    }
}
