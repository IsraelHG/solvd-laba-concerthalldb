package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.FeedbackDAO;
import com.solvd.laba.database.dao.FeedbackDAOImpl;
import com.solvd.laba.database.model.Feedback;

import java.sql.SQLException;

/**
 * The FeedbackService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class FeedbackService {
    private final FeedbackDAO feedbackDAO;

    public FeedbackService() {
        this.feedbackDAO = new FeedbackDAOImpl();
    }

    /**
     * Retrieves a feedback with the specified ID.
     *
     * @param feedbackId the ID of the feedback to retrieve
     * @return the feedback object with the specified ID
     * @throws SQLException if an error occurs while accessing the database
     */
    public Feedback getFeedback(int feedbackId) throws SQLException {
        return feedbackDAO.get(feedbackId);
    }

    /**
     * Sets a feedback and inserts it into the database along with its credentials.
     *
     * @param feedback feedback object to be pushed into the server
     * @throws SQLException if an error occurs while accessing the database
     */
    public void setFeedback(Feedback feedback) throws SQLException {
        feedbackDAO.insert(feedback);
    }

    /**
     * Saves a feedback object in the database. This method is used for either inserting a new feedback or updating an existing one.
     *
     * @param feedback the feedback object to save
     * @throws SQLException if an error occurs while accessing the database
     */
    public void saveFeedback(Feedback feedback) throws SQLException {
        feedbackDAO.save(feedback);
    }

    /**
     * Deletes a feedback object from the database.
     *
     * @param feedback the feedback object to delete
     * @throws SQLException if an error occurs while accessing the database
     */
    public void deleteFeedback(Feedback feedback) throws SQLException {
        feedbackDAO.delete(feedback);
    }

}
