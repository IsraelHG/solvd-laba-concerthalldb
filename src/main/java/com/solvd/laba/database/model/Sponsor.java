package com.solvd.laba.database.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sponsor {
    @JsonProperty("sponsorId")
    private int sponsorId;

    @JsonProperty("sponsorName")
    private String name;

    @JsonProperty("sponsorshipAmount")
    private double sponsorshipAmount;

    public Sponsor() {}

    public Sponsor(int sponsorId, String name, double sponsorshipAmount) {
        this.sponsorId = sponsorId;
        this.name = name;
        this.sponsorshipAmount = sponsorshipAmount;
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

    public double getSponsorshipAmount() {
        return sponsorshipAmount;
    }

    public void setSponsorshipAmount(double sponsorshipAmount) {
        this.sponsorshipAmount = sponsorshipAmount;
    }

    @Override
    public String toString() {
        return "Sponsors{" +
                "sponsorId=" + sponsorId +
                ", name='" + name +
                ", sponsorshipAmount='" + sponsorshipAmount + '\'' +
                '}';
    }
}
