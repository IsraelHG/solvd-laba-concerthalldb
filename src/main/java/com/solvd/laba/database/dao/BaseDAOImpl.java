package com.solvd.laba.database.dao;

import com.solvd.laba.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class BaseDAOImpl<T> implements BaseDAO<T> {

    /**
     * Maps the current row of the ResultSet to an entity object.
     *
     * @param resultSet The ResultSet containing the row to be mapped.
     * @return An entity object representing the mapped row.
     * @throws SQLException if a database access error occurs or if the column labels
     *                       in the ResultSet do not match the corresponding properties
     *                       in the entity class.
     */
    protected abstract T mapRow(ResultSet resultSet) throws SQLException;

    @Override
    public T get(int id) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM " + getTableName() + " WHERE " + getIdColumnName() + "=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // If a record is found, map it to an object of type T
                return mapRow(resultSet);
            }
            // No record found for the specified ID
            return null;
        } catch (SQLException e) {
            // Handle any potential database access errors
            e.printStackTrace();
            return null;
        } finally {
            connection.close();
        }
    }

    @Override
    public ArrayList<T> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(T t) throws SQLException {
        return 0;
    }

    @Override
    public int insert(T t) throws SQLException {
        return 0;
    }

    @Override
    public int update(T t) throws SQLException {
        return 0;
    }

    @Override
    public int delete(T t) throws SQLException {
        return 0;
    }

    /**
     * Retrieves the name of the table associated with the Venues class.
     *
     * @return The name of the table.
     */
    protected abstract String getTableName();

    /**
     * Retrieves the name of the ID column associated with the Venues class.
     *
     * @return The name of the ID column.
     */
    protected abstract String getIdColumnName();

    /**
     * Retrieves the ID value from the specified Venues entity.
     *
     * @param entity The Venues entity from which to retrieve the ID value.
     * @return The ID value.
     */
    protected abstract int getId(T entity);

    /**
     * Retrieves the column values to be inserted for the specified Venues entity.
     *
     * @param entity The Venues entity for which to retrieve the column values.
     * @return The column values string.
     */
    protected abstract String getInsertValues(T entity);

    /**
     * Retrieves the column values to be updated for the specified Venues entity.
     *
     * @param entity The Venues entity for which to retrieve the column values.
     * @return The column values string.
     */
    protected abstract String getUpdateValues(T entity);
}
