package com.solvd.laba.database.interfaces;

import com.solvd.laba.database.model.Feedback;

import java.util.ArrayList;


/**
 * The IFeedbackService interface provides a contract for accessing and manipulating feedback data.
 * It defines methods for retrieving, inserting, updating, and deleting feedback objects.
 */
public interface IFeedbackService {
    /**
     * Retrieves feedback with the specified ID.
     *
     * @param id the ID of the feedback to retrieve
     * @return the feedback object with the specified ID, or null if not found
     */
    Feedback getFeedbackById(int id);

    /**
     * Retrieves a list of all feedbacks.
     *
     * @return an ArrayList containing all feedbacks
     */
    ArrayList<Feedback> getFeedbacks();

    /**
     * Inserts new feedback into the database.
     *
     * @param feedback the feedback object to insert
     */
    void setFeedback(Feedback feedback);

    /**
     * Updates existing feedback in the database.
     *
     * @param feedback the feedback object to update
     */
    void updateFeedback(Feedback feedback);

    /**
     * Deletes a feedback from the database.
     *
     * @param feedback the feedback object to delete
     */
    void deleteFeedback(Feedback feedback);
}
