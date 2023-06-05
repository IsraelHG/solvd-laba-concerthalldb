package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.Venues;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The VenuesDAO interface extends the BaseDAO interface and provides specific data access operations for managing
 * venues in the database.
 */
public interface VenuesDAO extends BaseDAO<Venues> {
    ArrayList<Venues> fetchVenuesForEvent(int eventId);
}
