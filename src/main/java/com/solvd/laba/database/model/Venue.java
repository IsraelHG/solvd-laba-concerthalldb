package com.solvd.laba.database.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.SQLException;


@XmlAccessorType(XmlAccessType.FIELD)
public class Venue {
    @XmlElement(name="venueId")
    private int venueId;

    @XmlElement(name="venueName")
    private String name;

    @XmlElement(name="city")
    private String city;

    @XmlElement(name="state")
    private String state;

    @XmlElement(name="capacity")
    private int capacity;

    @XmlElement(name="website")
    private String website;

    public Venue() {}

    public Venue(int venueId, String name, String city, String state, int capacity, String website) {
        this.venueId = venueId;
        this.name = name;
        this.city = city;
        this.state = state;
        this.capacity = capacity;
        this.website = website;
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

    /**
     * Retrieves and populates the events associated with the venue.
     *
     * @param eventDAO The EventsDAO used to fetch the events.
     * @throws SQLException if a database access error occurs.
     */
//    public void getEvents(EventsDAO eventDAO) throws SQLException {
//        if (eventDAO != null) {
//            setEvents(eventDAO.fetchEventsForVenue(venueId));
//        }
//    }

    @Override
    public String toString() {
        return "Venues{" +
                "venueId=" + venueId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", capacity=" + capacity +
                ", website='" + website + '\'' +
                '}';
    }
}
