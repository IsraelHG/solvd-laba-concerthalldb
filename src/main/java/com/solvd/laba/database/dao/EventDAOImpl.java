package com.solvd.laba.database.dao;

import com.solvd.laba.database.Database;
import com.solvd.laba.database.model.Event;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The EventsDAOImpl class is an implementation of the EventsDAO interface that provides
 * methods to interact with the Events table in the database using JDBC.
 */
public class EventDAOImpl extends BaseDAOImpl<Event> implements EventDAO {
    private static final String EVENT_ID = "event_id";
    private static final String NAME = "name";
    private static final String START_DATE = "start_date";
    private static final String END_DATE = "end_date";
    private static final String TABLE_NAME = "events";

    @Override
    protected Event mapRow(ResultSet resultSet) throws SQLException {
        Event event = new Event();
        event.setEventId(resultSet.getInt(EVENT_ID));
        event.setName(resultSet.getString(NAME));
        // Retrieve the start date as a Timestamp from the ResultSet
        Timestamp startTimestamp = resultSet.getTimestamp(START_DATE);
        if (startTimestamp != null) {
            // Convert the Timestamp to LocalDateTime
            LocalDateTime startDate = startTimestamp.toLocalDateTime();
            event.setStartDate(startDate);
        }
        // Retrieve the end date as a Timestamp from the ResultSet
        Timestamp endTimestamp = resultSet.getTimestamp(END_DATE);
        if (endTimestamp != null) {
            // Convert the Timestamp to LocalDateTime
            LocalDateTime endDate = endTimestamp.toLocalDateTime();
            event.setEndDate(endDate);
        }

        return event;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected String getIdColumnName() {
        return EVENT_ID;
    }

    @Override
    protected int getId(Event entity) {
        return entity.getEventId();
    }

    @Override
    protected String getInsertValues(Event entity) {
        return "(" + NAME + ", " + START_DATE + ", " + END_DATE + ") VALUES ('" +
                entity.getName() + "', '" + entity.getStartDate() + "', '" + entity.getEndDate() + "');";
    }

    @Override
    protected String getUpdateValues(Event entity) {
        return NAME + " = '" + entity.getName() + "', " + START_DATE + " = '" + entity.getStartDate() +
                "', " + END_DATE + " = '" + entity.getEndDate() + "'";
    }

//    @Override
//    public ArrayList<Event> fetchEventsForVenue(int venueId) {
//        ArrayList<Event> eventsList = new ArrayList<>();
//        String sql = "SELECT * FROM events_has_venues WHERE venue_id=?";
//        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setInt(1, venueId);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                // Fetch the event details based on the event ID from the events table
//                int eventId = resultSet.getInt("event_id");
//                Event event = fetchEventById(eventId);
//                if (event != null) {
//                    eventsList.add(event);
//                }
//            }
//        } catch (SQLException e) {
//            // Handle any potential database access errors
//            e.printStackTrace();
//        }
//        return eventsList;
//    }

    /**
     * Fetches an event from the database based on the provided event ID.
     *
     * @param eventId The ID of the event to fetch.
     * @return The Events object representing the fetched event, or null if the event is not found.
     */
//    private Event fetchEventById(int eventId) {
//        String sql = "SELECT * FROM events WHERE event_id=?";
//        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setInt(1, eventId);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                // Retrieve the event details from the ResultSet
//                int fetchedEventId = resultSet.getInt("event_id");
//                String name = resultSet.getString("name");
//                LocalDateTime startDate = resultSet.getTimestamp("start_date").toLocalDateTime();
//                LocalDateTime endDate = resultSet.getTimestamp("end_date").toLocalDateTime();
//
//                // Create an Events object with the fetched details
//                return new Event(fetchedEventId, name, startDate, endDate);
//            }
//        } catch (SQLException e) {
//            // Handle any potential database access errors
//            e.printStackTrace();
//        }
//        return null; // Return null if the event is not found
//    }
}
