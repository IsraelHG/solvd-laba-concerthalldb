package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.EventsHasVenues;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventsHasVenuesDAOImpl extends BaseDAOImpl<EventsHasVenues> implements EventsHasVenuesDAO {
    @Override
    protected EventsHasVenues mapRow(ResultSet resultSet) throws SQLException {
        EventsHasVenues eventsHasVenues = new EventsHasVenues();
        eventsHasVenues.setEventsHasVenueId(resultSet.getInt("events_has_venue_id"));
        eventsHasVenues.setEventId(resultSet.getInt("event_id"));
        eventsHasVenues.setVenueId(resultSet.getInt("venue_id"));
        return eventsHasVenues;
    }

    @Override
    protected String getTableName() {
        return "events_has_venues";
    }

    @Override
    protected String getIdColumnName() {
        return "events_has_venue_id";
    }

    @Override
    protected int getId(EventsHasVenues entity) {
        return entity.getEventsHasVenueId();
    }

    @Override
    protected String getInsertValues(EventsHasVenues entity) {
        return "'" + entity.getEventsHasVenueId() + "', '" + entity.getEventId() + "', '" + entity.getVenueId() + "'";
    }

    @Override
    protected String getUpdateValues(EventsHasVenues entity) {
        return "eventId='" + entity.getEventId() + "', venueId='" + entity.getVenueId() + "'";
    }
}
