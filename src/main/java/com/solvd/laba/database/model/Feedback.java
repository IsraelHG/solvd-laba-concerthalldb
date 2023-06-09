package com.solvd.laba.database.model;

public class Feedback {
    private int feedbackId;
    private Event event;
    private Audience audience;
    private int rating;

    public Feedback(){}

    public Feedback(int feedbackId, Event event, Audience audience, int rating) {
        this.feedbackId = feedbackId;
        this.event = event;
        this.audience = audience;
        this.rating = rating;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", event=" + event +
                ", audience=" + audience +
                ", rating=" + rating +
                '}';
    }
}
