package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.EventsDAO;
import com.solvd.laba.database.dao.EventsDAOImpl;
import com.solvd.laba.database.dao.VenuesDAO;
import com.solvd.laba.database.dao.VenuesDAOImpl;
import com.solvd.laba.database.model.Events;
import com.solvd.laba.database.model.Venues;

import java.sql.SQLException;
import java.util.ArrayList;

public class VenueService {
    /**
     * Retrieves a venue with the specified ID along with its associated events.
     *
     * @param venueId the ID of the venue to retrieve
     * @return the venue object with the specified ID, including its associated events
     * @throws SQLException if an error occurs while accessing the database
     */
    public Venues getVenue(int venueId) throws SQLException {
        VenuesDAO venuesDAO = new VenuesDAOImpl();
        EventsDAO eventsDAO = new EventsDAOImpl();

        // Retrieve the venue with the specified ID from the database
        Venues venue = venuesDAO.get(venueId);

        // Fetch the events associated with the venue
        ArrayList<Events> events = eventsDAO.fetchEventsForVenue(venueId);

        // Set the fetched events to the venue object
        venue.setEvents(events);
        return venue;
    }
}
