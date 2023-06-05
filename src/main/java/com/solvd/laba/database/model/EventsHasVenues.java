package com.solvd.laba.database.model;

public class EventsHasVenues {
    private int eventsHasVenueId;
    private int eventId;
    private int venueId;

    public EventsHasVenues() {}
    EventsHasVenues(int eventsHasVenueId, int eventId, int venueId) {
        this.eventsHasVenueId = eventsHasVenueId;
        this.eventId = eventId;
        this.venueId = venueId;
    }

    public int getEventsHasVenueId() {
        return eventsHasVenueId;
    }

    public void setEventsHasVenueId(int eventsHasVenueId) {
        this.eventsHasVenueId = eventsHasVenueId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    @Override
    public String toString() {
        return "EventsHasVenues{" +
                "eventsHasVenueId=" + eventsHasVenueId +
                ", eventId=" + eventId +
                ", venueId=" + venueId +
                '}';
    }
}
