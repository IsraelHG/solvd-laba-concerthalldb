package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.Audience;
import com.solvd.laba.database.model.Event;
import com.solvd.laba.database.model.Feedback;

import java.sql.SQLException;

/**
 * The FeedbackDAO interface extends the BaseDAO interface and provides specific data access operations for managing
 * feedbacks in the database.
 */
public interface FeedbackDAO extends BaseDAO<Feedback> {

    /**
     * Retrieves the event associated with a specific feedback.
     *
     * @param eventId The ID of the Event.
     * @return The Event associated with the Feedback.
     * @throws SQLException If an error occurs while accessing the database.
     */
    Event fetchEventForFeedback(int eventId) throws SQLException;

    /**
     * Retrieves the Audience associated with a specific Feedback.
     *
     * @param audienceId The ID of the Audience.
     * @return The Audience associated with the Feedback.
     * @throws SQLException If an error occurs while accessing the database.
     */
    Audience fetchAudienceForFeedback(int audienceId) throws SQLException;
}
