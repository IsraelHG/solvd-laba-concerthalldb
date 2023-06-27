package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.EventDAO;
import com.solvd.laba.database.dao.EventDAOImpl;
import com.solvd.laba.database.dao.VenueDAO;
import com.solvd.laba.database.dao.VenueDAOImpl;
import com.solvd.laba.database.interfaces.IEventService;
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
public class EventService implements IEventService {
    private final EventDAO eventDAO;
    private final VenueDAO venueDAO;

    public EventService() {
        venueDAO = new VenueDAOImpl();
        eventDAO = new EventDAOImpl();
    }

    public Event getEventById(int eventId) {
        try {
            Event event = eventDAO.get(eventId);
            ArrayList<Venue> venues = venueDAO.fetchVenuesForEvent(eventId);
            event.setVenues(venues);
            return event;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Event> getEvents() {
        try {
            return eventDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void setEvent(Event event) {
        try {
            eventDAO.insert(event);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEvent(Event event) {
        try {
            eventDAO.update(event);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public void deleteEvent(Event event) {
        try {
            eventDAO.delete(event);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
