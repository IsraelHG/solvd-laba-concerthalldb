package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.Events;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The EventsDAO interface extends the BaseDAO interface and provides specific data access operations for managing
 * events in the database.
 */
public interface EventsDAO extends BaseDAO<Events>{
    ArrayList<Events> fetchEventsForVenue(int venueId);

}
