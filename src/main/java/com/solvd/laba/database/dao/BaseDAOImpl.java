package com.solvd.laba.database.dao;

import com.solvd.laba.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

abstract class BaseDAOImpl<T> implements BaseDAO<T> {
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
        final String sql = "SELECT * FROM " + getTableName() + " WHERE " + getIdColumnName() + "=?";
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
            Database.releaseConnection(connection);
        }
    }

    @Override
    public ArrayList<T> getAll() throws SQLException {
        ArrayList<T> resultList = new ArrayList<>();
        final String sql = "SELECT * FROM " + getTableName();
        Connection connection = Database.getConnection();
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                T entity = mapRow(resultSet);
                resultList.add(entity);
            }
        } catch (SQLException e) {
            // Handle any potential database access errors
            e.printStackTrace();
        } finally {
            Database.releaseConnection(connection);
        }
        return resultList;
    }

    @Override
    public void save(T t) throws SQLException {
        int id = getId(t);
        if (id != 0) {
            update(t);
        } else {
            insert(t);
        }
    }

    @Override
    public void insert(T t) throws SQLException {
        Connection connection = Database.getConnection();
        final String sql = "INSERT INTO " + getTableName() + getInsertValues(t);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database.releaseConnection(connection);
        }
    }

    @Override
    public void update(T t) throws SQLException {
        Connection connection = Database.getConnection();
        final String sql = "UPDATE " + getTableName() + " SET " + getUpdateValues(t) + " WHERE " + getIdColumnName() + "=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, getId(t));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database.releaseConnection(connection);
        }
    }

    @Override
    public int delete(T t) throws SQLException {
        Connection connection = Database.getConnection();
        final String sql = "DELETE FROM " + getTableName() + " WHERE " + getIdColumnName() + "=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, getId(t));
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            Database.releaseConnection(connection);
        }
    }

    /**
     * Retrieves the name of the table associated with the entity's class.
     *
     * @return The name of the table.
     */
    protected abstract String getTableName();

    /**
     * Retrieves the name of the ID column associated with the entity's class.
     *
     * @return The name of the ID column.
     */
    protected abstract String getIdColumnName();

    /**
     * Retrieves the ID value from the specified entity's entity.
     *
     * @param entity The generic entity from which to retrieve the ID value.
     * @return The ID value.
     */
    protected abstract int getId(T entity);

    /**
     * Retrieves the column values to be inserted for the specified generic entity.
     *
     * @param entity The generic entity for which to retrieve the column values.
     * @return The column values string.
     */
    protected abstract String getInsertValues(T entity);

    /**
     * Retrieves the column values to be updated for the specified generic entity.
     *
     * @param entity The generic entity for which to retrieve the column values.
     * @return The column values string.
     */
    protected abstract String getUpdateValues(T entity);
}
