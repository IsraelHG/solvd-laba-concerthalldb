package com.solvd.laba.database.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event {
    private int eventId;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private ArrayList<Venue> venues;
    private ArrayList<Artist> artists;
    private ArrayList<Equipment> equipments;
    private ArrayList<Sponsor> sponsors;

    public Event() {}

    public Event(int eventId, String name, LocalDateTime startDate, LocalDateTime endDate) {
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

    public ArrayList<Venue> getVenues() {
        return venues;
    }

    public void setVenues(ArrayList<Venue> venues) {
        this.venues = venues;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(ArrayList<Equipment> equipments) {
        this.equipments = equipments;
    }

    public ArrayList<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(ArrayList<Sponsor> sponsors) {
        this.sponsors = sponsors;
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
