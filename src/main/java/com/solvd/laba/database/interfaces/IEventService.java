package com.solvd.laba.database.interfaces;

import com.solvd.laba.database.model.Event;

import java.util.ArrayList;


/**
 * The IEventService interface provides a contract for accessing and manipulating event data.
 * It defines methods for retrieving, inserting, updating, and deleting event objects.
 */
public interface IEventService {
    /**
     * Retrieves event with the specified ID.
     *
     * @param id the ID of the event to retrieve
     * @return the event object with the specified ID, or null if not found
     */
    Event getEventById(int id);

    /**
     * Retrieves a list of all events.
     *
     * @return an ArrayList containing all events
     */
    ArrayList<Event> getEvents();

    /**
     * Inserts new event into the database.
     *
     * @param event the event object to insert
     */
    void setEvent(Event event);

    /**
     * Updates existing event in the database.
     *
     * @param event the event object to update
     */
    void updateEvent(Event event);

    /**
     * Deletes an event from the database.
     *
     * @param event the event object to delete
     */
    void deleteEvent(Event event);
}
