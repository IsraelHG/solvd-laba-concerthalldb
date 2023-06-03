package com.solvd.laba.database.interfaces;

import com.solvd.laba.database.Venues;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The VenuesDAO interface extends the generic DAO interface and provides specific data access operations for managing
 * venues in the database.
 */
public interface VenuesDAO extends DAO<Venues> {
    /**
     * Retrieves a venue from the database based on its ID.
     *
     * @param id the ID of the venue to retrieve
     * @return the retrieved venue, or null if not found
     * @throws SQLException if an error occurs while performing the database operation
     */
    @Override
    Venues get(int id) throws SQLException;

    /**
     * Retrieves all venues from the database.
     *
     * @return a list of all venues
     * @throws SQLException if an error occurs while performing the database operation
     */
    @Override
    ArrayList<Venues> getAll() throws SQLException;

    /**
     * Saves a venue in the database. This method is used for either inserting a new venue or updating an existing one.
     *
     * @param venues the venue to save
     * @return the number of affected rows in the database (1 for successful save, 0 otherwise)
     * @throws SQLException if an error occurs while performing the database operation
     */
    @Override
    int save(Venues venues) throws SQLException;

    /**
     * Inserts a new venue into the database.
     *
     * @param venues the venue to insert
     * @return the number of affected rows in the database (1 for successful insert, 0 otherwise)
     * @throws SQLException if an error occurs while performing the database operation
     */
    @Override
    int insert(Venues venues) throws SQLException;

    /**
     * Updates an existing venue in the database.
     *
     * @param venues the venue to update
     * @return the number of affected rows in the database (1 for successful update, 0 otherwise)
     * @throws SQLException if an error occurs while performing the database operation
     */
    @Override
    int update(Venues venues) throws SQLException;

    /**
     * Deletes a venue from the database.
     *
     * @param venues the venue to delete
     * @return the number of affected rows in the database (1 for successful deletion, 0 otherwise)
     * @throws SQLException if an error occurs while performing the database operation
     */
    @Override
    int delete(Venues venues) throws SQLException;
}
