package com.solvd.laba.database.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Artist {

    @XmlElement(name="artistId")
    private int artistId;

    @XmlElement(name="firstName")
    private String firstName;

    @XmlElement(name="lastName")
    private String lastName;

    @XmlElement(name="genre")
    private String genre;

    @XmlElement(name="email")
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
