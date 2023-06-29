package com.solvd.laba.database.model;

import com.solvd.laba.database.enums.Gender;

import java.util.ArrayList;

public class Audience {
    private int audienceId;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String email;
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Feedback> feedbacks = new ArrayList<>();

    public Audience() {}
    public Audience(String firstName, String lastName, int age, Gender gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }
    public Audience(int audienceId, String firstName, String lastName, int age, Gender gender, String email) {
        this.audienceId = audienceId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public int getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(int audienceId) {
        this.audienceId = audienceId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public ArrayList<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(ArrayList<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public String toString() {
        return "Audience{" +
                "audienceId=" + audienceId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", bookings=" + bookings +
                ", feedbacks=" + feedbacks +
                '}';
    }
}
