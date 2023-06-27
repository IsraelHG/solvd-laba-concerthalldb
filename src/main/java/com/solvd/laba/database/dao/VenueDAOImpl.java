package com.solvd.laba.database.dao;

import com.solvd.laba.database.Database;
import com.solvd.laba.database.model.Venue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The VenuesDAOImpl class is an implementation of the VenuesDAO interface that provides
 * methods to interact with the Venues table in the database using JDBC.
 */
public class VenueDAOImpl extends BaseDAOImpl<Venue> implements VenueDAO {
    private static final String VENUE_ID = "venue_id";
    private static final String NAME = "name";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String CAPACITY = "capacity";
    private static final String WEBSITE = "website";
    private static final String TABLE_NAME = "venues";

    @Override
    protected Venue mapRow(ResultSet resultSet) throws SQLException {
        Venue venue = new Venue();
        venue.setVenueId(resultSet.getInt(VENUE_ID));
        venue.setName(resultSet.getString(NAME));
        venue.setCity(resultSet.getString(CITY));
        venue.setState(resultSet.getString(STATE));
        venue.setCapacity(resultSet.getInt(CAPACITY));
        venue.setWebsite(resultSet.getString(WEBSITE));
        return venue;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected String getIdColumnName() {
        return VENUE_ID;
    }

    @Override
    protected int getId(Venue entity) {
        return entity.getVenueId();
    }

    @Override
    protected String getInsertValues(Venue entity) {
        return "(" + NAME + ", " + CITY  + ", " + STATE  + ", " + CAPACITY  + ", " + WEBSITE  + ") VALUES ('" +
                entity.getName() + "', '" + entity.getCity() + "', '" + entity.getState() + "', '" +
                entity.getCapacity() + "', '" + entity.getWebsite() + "');";
    }

    @Override
    protected String getUpdateValues(Venue entity) {
        return NAME + "='" + entity.getName() + "', " +
                CITY + "='" + entity.getCity() + "', " +
                STATE + "='" + entity.getState() + "', " +
                CAPACITY + "='" + entity.getCapacity() + "', " +
                WEBSITE + "='" + entity.getWebsite() + "'";
    }

    @Override
    public ArrayList<Venue> fetchVenuesForEvent(int eventId) throws SQLException {
        ArrayList<Venue> venueList = new ArrayList<>();
        final String sql = "SELECT * FROM events_has_venues WHERE event_id=?";
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, eventId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int venueId = resultSet.getInt(VENUE_ID);
                Venue venue = fetchVenueById(venueId, connection);
                if (venue != null) {
                    venueList.add(venue);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database.releaseConnection(connection);
        }
        return venueList;
    }

    /**
     * Fetches a venue from the database based on the provided venue ID.
     *
     * @param venueId The ID of the venue to fetch.
     * @return The Venues object representing the fetched venue, or null if the venue is not found.
     */
    private Venue fetchVenueById(int venueId, Connection connection) throws SQLException {
        final String sql = "SELECT * FROM venues WHERE venue_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, venueId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapRow(resultSet);
            }
        } catch (SQLException e) {
            // Handle any potential database access errors
            e.printStackTrace();
        }
        return null; // Return null if the venue is not found
    }
}