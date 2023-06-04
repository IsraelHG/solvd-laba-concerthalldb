package com.solvd.laba.database.dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The DAO (Data Access Object) interface provides a contract for performing CRUD (Create, Retrieve, Update, Delete)
 * operations on a specific entity type.
 *
 * @param <T> the type of entity managed by this DAO
 */
public interface BaseDAO<T> {
    /**
     * Retrieves an entity from the database based on its ID.
     *
     * @param id the ID of the entity to retrieve
     * @return the retrieved entity, or null if not found
     * @throws SQLException if an error occurs while performing the database operation
     */
    T get(int id) throws SQLException;

    /**
     * Retrieves all entities of the managed type from the database.
     *
     * @return a list of all entities
     * @throws SQLException if an error occurs while performing the database operation
     */
    ArrayList<T> getAll() throws SQLException;

    /**
     * Saves an entity in the database. This method is used for either inserting a new entity or updating an existing one.
     *
     * @param t the entity to save
     * @return the number of affected rows in the database (1 for successful save, 0 otherwise)
     * @throws SQLException if an error occurs while performing the database operation
     */
    int save(T t) throws SQLException;

    /**
     * Inserts a new entity into the database.
     *
     * @param t the entity to insert
     * @return the number of affected rows in the database (1 for successful insert, 0 otherwise)
     * @throws SQLException if an error occurs while performing the database operation
     */
    int insert(T t) throws SQLException;

    /**
     * Updates an existing entity in the database.
     *
     * @param t the entity to update
     * @return the number of affected rows in the database (1 for successful update, 0 otherwise)
     * @throws SQLException if an error occurs while performing the database operation
     */
    int update(T t) throws SQLException;

    /**
     * Deletes an entity from the database.
     *
     * @param t the entity to delete
     * @return the number of affected rows in the database (1 for successful deletion, 0 otherwise)
     * @throws SQLException if an error occurs while performing the database operation
     */
    int delete(T t) throws SQLException;
}
