package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.EventDAO;
import com.solvd.laba.database.dao.EventDAOImpl;
import com.solvd.laba.database.dao.VenueDAO;
import com.solvd.laba.database.dao.VenueDAOImpl;
import com.solvd.laba.database.model.Event;
import com.solvd.laba.database.model.Venue;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The EventService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class EventService {
    private final EventDAO eventDAO;
    private final VenueDAO venueDAO;

    public EventService() {
        venueDAO = new VenueDAOImpl();
        eventDAO = new EventDAOImpl();
    }

    /**
     * Retrieves an event with the specified ID along with its associated venues.
     *
     * @param eventId the ID of the event to retrieve
     * @return the event object with the specified ID, including its associated venues
     * @throws SQLException if an error occurs while accessing the database
     */
    public Event getEvent(int eventId) throws SQLException {
        Event event = eventDAO.get(eventId);
        ArrayList<Venue> venues = venueDAO.fetchVenuesForEvent(eventId);
        event.setVenues(venues);
        return event;
    }

    /**
     * Sets an event and inserts it into the database along with its credentials.
     *
     * @param event event object to be pushed into the server
     * @throws SQLException if an error occurs while accessing the database
     */
    public void setEvent(Event event) throws SQLException {
        eventDAO.insert(event);
    }

    /**
     * Saves an event object in the database. This method is used for either inserting a new event or updating an existing one.
     *
     * @param event the event object to save
     * @throws SQLException if an error occurs while accessing the database
     */
    public void saveEvent(Event event) throws SQLException {
        eventDAO.save(event);
    }

    /**
     * Deletes an event object from the database.
     *
     * @param event the event object to delete
     * @throws SQLException if an error occurs while accessing the database
     */
    public void deleteEvent(Event event) throws SQLException {
        eventDAO.delete(event);
    }

}
