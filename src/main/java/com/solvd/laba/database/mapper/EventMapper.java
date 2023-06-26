package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Event;

import java.util.ArrayList;

public interface EventMapper {
    /**
     * Retrieves an event from the database based on the provided ID.
     *
     * @param id the ID of the event
     * @return the event object if found, null otherwise
     */
    Event getEventById(int id);

    ArrayList<Event> getEvents();

    /**
     * Inserts a new event into the database.
     *
     * @param event the event object to be inserted
     */
    void insertEvent(Event event);

    /**
     * Updates an existing event in the database.
     *
     * @param event the event object to be updated
     */
    void updateEvent(Event event);

    /**
     * Deletes an event from the database based on the provided object.
     *
     * @param id the ID of the event to be deleted
     */
    void deleteEvent(Event event);

}
