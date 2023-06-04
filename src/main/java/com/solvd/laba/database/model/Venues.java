package com.solvd.laba.database.model;

public class Venues {
    private int venueId;
    private String name;
    private String city;
    private String state;
    private int capacity;
    private String website;

    public Venues() {}

    public Venues(int venueId, String name, String city, String state, int capacity, String website) {
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
