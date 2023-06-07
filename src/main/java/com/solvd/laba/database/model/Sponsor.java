package com.solvd.laba.database.model;

public class Sponsor {
    private int sponsorId;
    private String name;
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
