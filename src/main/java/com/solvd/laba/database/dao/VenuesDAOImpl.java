package com.solvd.laba.database.dao;

import com.solvd.laba.database.Database;
import com.solvd.laba.database.model.Venues;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        return entity.getVenueId() + "', '" + entity.getName() + "', '" + entity.getCity() + "', '"
                + entity.getState() + "', '" + entity.getCapacity() + "', '" + entity.getWebsite();
    }

    @Override
    protected String getUpdateValues(Venues entity) {
        return "name = '" + entity.getName() + "', city = '" + entity.getCity() + "', state = '"
                + entity.getState() + "', capacity = '" + entity.getCapacity() + "', website = '" + entity.getWebsite();
    }

    /**
     * Fetches the venues associated with a specific event.
     *
     * @param eventId The ID of the event for which to fetch the venues.
     * @return An ArrayList of Venues objects representing the venues associated with the event,
     *         or an empty ArrayList if no venues are found.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public ArrayList<Venues> fetchVenuesForEvent(int eventId) {
        ArrayList<Venues> venueList = new ArrayList<>();
        String sql = "SELECT * FROM events_has_venues WHERE event_id=?";
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, eventId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int venueId = resultSet.getInt("venue_id");
                Venues venue = fetchVenueById(venueId);
                if (venue != null) {
                    venueList.add(venue);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venueList;


    }

    /**
     * Fetches a venue from the database based on the provided venue ID.
     *
     * @param venueId The ID of the venue to fetch.
     * @return The Venues object representing the fetched venue, or null if the venue is not found.
     */
    private Venues fetchVenueById(int venueId) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM venues WHERE venue_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, venueId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int fetchedVenueId = resultSet.getInt("venue_id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int capacity = resultSet.getInt("capacity");
                String website = resultSet.getString("website");

                // Create a Venues object with the fetched details
                return new Venues(fetchedVenueId, name, city, state, capacity, website);
            }
        } catch (SQLException e) {
            // Handle any potential database access errors
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return null; // Return null if the venue is not found
    }
}
