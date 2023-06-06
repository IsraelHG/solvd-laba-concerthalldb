package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.EventDAO;
import com.solvd.laba.database.dao.EventDAOImpl;
import com.solvd.laba.database.dao.VenueDAO;
import com.solvd.laba.database.dao.VenueDAOImpl;
import com.solvd.laba.database.model.Event;
import com.solvd.laba.database.model.Venue;

import java.sql.SQLException;
import java.util.ArrayList;

public class EventService {

    /**
     * Retrieves an event with the specified ID along with its associated venues.
     *
     * @param eventId the ID of the event to retrieve
     * @return the event object with the specified ID, including its associated venues
     * @throws SQLException if an error occurs while accessing the database
     */
    public Event getEvent(int eventId) throws SQLException {

    EventDAO eventsDAO = new EventDAOImpl();
    Event event = eventsDAO.get(eventId);

    VenueDAO venuesDAO = new VenueDAOImpl();
    ArrayList<Venue> venues = venuesDAO.fetchVenuesForEvent(eventId);
    event.setVenues(venues);
    return event;
    }

}
