package com.solvd.laba.database.model;

import com.solvd.laba.database.dao.VenuesDAO;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Events {
    private int eventId;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private ArrayList<Venues> venues;

    public Events() {}

    public Events(int eventId, String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.eventId = eventId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Venues> getVenues() {
        return venues;
    }

    public void setVenues(ArrayList<Venues> venues) {
        this.venues = venues;
    }

//    public void getVenues(VenuesDAO venueDAO) throws SQLException {
//        if (venueDAO != null) {
//            setVenues(venueDAO.fetchVenuesForEvent(eventId));
//        }
//    }

    @Override
    public String toString() {
        return "Events{" +
                "eventId=" + eventId +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", venues=" + venues +
                '}';
    }
}
