package com.solvd.laba.database.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "event", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {
    @XmlElement(name="eventId")
    private int eventId;

    @XmlElement(name="name")
    private String name;

    @XmlElement(name="startDate")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime startDate;

    @XmlElement(name="endDate")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime endDate;

    @XmlElement(name = "venue")
    @XmlElementWrapper(name = "venues")
    private ArrayList<Venue> venues;

    @XmlElement(name = "artist")
    @XmlElementWrapper(name = "artists")
    private ArrayList<Artist> artists;

    @XmlElement(name = "equipment")
    @XmlElementWrapper(name = "equipments")
    private ArrayList<Equipment> equipments;

    @XmlElement(name = "sponsor")
    @XmlElementWrapper(name = "sponsors")
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

    /**
     * Adapter class for marshalling and unmarshalling LocalDateTime objects.
     * Converts LocalDateTime objects to and from their XML representation as strings.
     */
    private static class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
        /**
         * Converts the XML representation (string) of a LocalDateTime object to a LocalDateTime instance.
         *
         * @param value The XML representation of the LocalDateTime object.
         * @return The unmarshalled LocalDateTime object.
         */
        @Override
        public LocalDateTime unmarshal(String value) {
            return LocalDateTime.parse(value);
        }
        /**
         * Converts a LocalDateTime object to its XML representation (string).
         *
         * @param value The LocalDateTime object to be marshalled.
         * @return The XML representation of the LocalDateTime object.
         */
        @Override
        public String marshal(LocalDateTime value) {
            return value.toString();
        }
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
