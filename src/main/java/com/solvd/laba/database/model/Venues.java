package com.solvd.laba.database.model;

import com.solvd.laba.database.dao.EventsDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Venues {
    private int venueId;
    private String name;
    private String city;
    private String state;
    private int capacity;
    private String website;
    private ArrayList<Events> events;

    public Venues() {}

    public Venues(int venueId, String name, String city, String state, int capacity, String website) {
        this.venueId = venueId;
        this.name = name;
        this.city = city;
        this.state = state;
        this.capacity = capacity;
        this.website = website;
        this.events = new ArrayList<>();
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Events> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Events> events) {
        this.events = events;
    }

    /**
     * Retrieves and populates the events associated with the venue.
     *
     * @param eventDAO The EventsDAO used to fetch the events.
     * @throws SQLException if a database access error occurs.
     */
    public void getEvents(EventsDAO eventDAO) throws SQLException {
        if (eventDAO != null) {
            setEvents(eventDAO.fetchEventsForVenue(venueId));
        }
    }

    @Override
    public String toString() {
        return "Venues{" +
                "venueId=" + venueId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", capacity=" + capacity +
                ", website='" + website + '\'' +
                ", events=" + events +
                '}';
    }
}
