package com.solvd.laba.database.model;

import java.util.ArrayList;

public class Artist {
    private int artistId;
    private String name;
    private String genre;
    ArrayList<Event> events;

    public Artist() {}

    public Artist(int artistId, String name, String genre) {
        this.artistId = artistId;
        this.name = name;
        this.genre = genre;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Artists{" +
                "artistId=" + artistId +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", events=" + events +
                '}';
    }
}
