package com.solvd.laba.database.model;

import java.util.ArrayList;

public class Sponsor {
    private int sponsorId;
    private String name;
    private ArrayList<Event> events;

    public Sponsor() {}

    public Sponsor(int sponsorId, String name) {
        this.sponsorId = sponsorId;
        this.name = name;
        this.events = new ArrayList<>();
    }

    public int getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(int sponsorId) {
        this.sponsorId = sponsorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Sponsors{" +
                "sponsorId=" + sponsorId +
                ", name='" + name + '\'' +
                ", events=" + events +
                '}';
    }
}
