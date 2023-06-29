package com.solvd.laba.database.model;

import java.time.LocalDateTime;

public class Booking {
    private int bookingId;
    private LocalDateTime bookingDate;
    private Event event;
    private Audience audience;
    private Staff staff;
    private Ticket ticket;

    public Booking(){}

    public Booking(int bookingId, LocalDateTime bookingDate, Event event, Audience audience, Staff staff, Ticket ticket) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.event = event;
        this.audience = audience;
        this.staff = staff;
        this.ticket = ticket;
    }
    public Booking(LocalDateTime bookingDate, Event event, Audience audience, Staff staff, Ticket ticket) {
        this.bookingDate = bookingDate;
        this.event = event;
        this.audience = audience;
        this.staff = staff;
        this.ticket = ticket;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", event=" + event +
                ", audience=" + audience +
                ", staff=" + staff +
                ", ticket=" + ticket +
                '}';
    }
}
