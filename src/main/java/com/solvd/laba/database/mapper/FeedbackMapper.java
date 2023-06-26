package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Feedback;

import java.util.ArrayList;

public interface FeedbackMapper {
    /**
     * Retrieves feedback from the database based on the provided ID.
     *
     * @param id the ID of the feedback
     * @return the feedback object if found, null otherwise
     */
    Feedback getFeedbackById(int id);

    ArrayList<Feedback> getFeedbacks();

    /**
     * Inserts new feedback into the database.
     *
     * @param feedback the feedback object to be inserted
     */
    void insertFeedback(Feedback feedback);

    /**
     * Updates existing feedback in the database.
     *
     * @param feedback the feedback object to be updated
     */
    void updateFeedback(Feedback feedback);

    /**
     * Deletes feedback from the database based on the provided object.
     *
     * @param feedback the object of the feedback to be deleted
     */
    void deleteFeedback(Feedback feedback);
}
