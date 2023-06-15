package com.solvd.laba.database.model;

public class Ticket {
    private int ticketId;
    private String seatNumber;

    public Ticket(){}

    public Ticket(int ticketId, String seatNumber) {
        this.ticketId = ticketId;
        this.seatNumber = seatNumber;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
