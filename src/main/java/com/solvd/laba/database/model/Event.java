package com.solvd.laba.database.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.solvd.laba.database.json.annotations.serialize.LocalDateTimeDeserializer;
import com.solvd.laba.database.json.annotations.serialize.LocalDateTimeSerializer;
import com.solvd.laba.database.xml.annotations.adapters.LocalDateTimeAdapter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "event", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {
    @XmlElement(name="eventId")
    @JsonProperty("eventId")
    private int eventId;

    @XmlElement(name="eventName")
    @JsonProperty("eventName")
    private String name;

    @XmlElement(name="startDate")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @JsonProperty("startDate")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime startDate;

    @XmlElement(name="endDate")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @JsonProperty("endDate")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime endDate;

    @XmlElement(name = "venue")
    @XmlElementWrapper(name = "venues")
    @JsonProperty("venues")
    private ArrayList<Venue> venues = new ArrayList<>();

    @XmlElement(name = "artist")
    @XmlElementWrapper(name = "artists")
    @JsonProperty("artists")
    private ArrayList<Artist> artists = new ArrayList<>();

    @XmlElement(name = "equipment")
    @XmlElementWrapper(name = "equipments")
    @JsonProperty("equipments")
    private ArrayList<Equipment> equipments = new ArrayList<>();

    @XmlElement(name = "sponsor")
    @XmlElementWrapper(name = "sponsors")
    @JsonProperty("sponsors")
    private ArrayList<Sponsor> sponsors = new ArrayList<>();

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

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", venues=" + venues +
                ", artists=" + artists +
                ", equipments=" + equipments +
                ", sponsors=" + sponsors +
                '}';
    }
}
