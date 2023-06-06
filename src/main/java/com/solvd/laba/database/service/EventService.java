package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.EventsDAO;
import com.solvd.laba.database.dao.EventsDAOImpl;
import com.solvd.laba.database.dao.VenuesDAO;
import com.solvd.laba.database.dao.VenuesDAOImpl;
import com.solvd.laba.database.model.Events;
import com.solvd.laba.database.model.Venues;

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
    public Events getEvent(int eventId) throws SQLException {

    EventsDAO eventsDAO = new EventsDAOImpl();
    Events event = eventsDAO.get(eventId);

    VenuesDAO venuesDAO = new VenuesDAOImpl();
    ArrayList<Venues> venues = venuesDAO.fetchVenuesForEvent(eventId);
    event.setVenues(venues);
    return event;
    }

}
