package com.solvd.laba.database.model;

public class Artist {
    private int artistId;
    private String firstName;
    private String lastName;
    private String genre;
    private String email;


    public Artist() {}

    public Artist(int artistId, String firstName, String lastName, String genre, String email) {
        this.artistId = artistId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.genre = genre;
        this.email = email;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Artists{" +
                "artistId=" + artistId +
                ", firstName='" + firstName +
                ", lastName='" + lastName +
                ", genre='" + genre +
                ", email='" + email + '\'' +
                '}';
    }
}
