package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.Venues;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The VenuesDAOImpl class is an implementation of the VenuesDAO interface that provides
 * methods to interact with the Venues table in the database using JDBC.
 */
public class VenuesDAOImpl extends BaseDAOImpl<Venues> implements VenuesDAO {

    @Override
    protected Venues mapRow(ResultSet resultSet) throws SQLException {
        Venues venue = new Venues();
        venue.setVenueId(resultSet.getInt("venue_id"));
        venue.setName(resultSet.getString("name"));
        venue.setCity(resultSet.getString("city"));
        venue.setState(resultSet.getString("state"));
        venue.setCapacity(resultSet.getInt("capacity"));
        venue.setWebsite(resultSet.getString("website"));
        return venue;
    }

    @Override
    protected String getTableName() {
        return "Venues";
    }

    @Override
    protected String getIdColumnName() {
        return "venue_id";
    }

    @Override
    protected int getId(Venues entity) {
        return entity.getVenueId();
    }

    @Override
    protected String getInsertValues(Venues entity) {
        return entity.getVenueId() + ", '" + entity.getName() + "', '" + entity.getCity() + "', '"
                + entity.getState() + "', " + entity.getCapacity() + ", " + entity.getWebsite();
    }

    @Override
    protected String getUpdateValues(Venues entity) {
        return "name = '" + entity.getName() + "', city = '" + entity.getCity() + "', state = '"
                + entity.getState() + "', capacity = " + entity.getCapacity() + ", " + entity.getWebsite();
    }
}
