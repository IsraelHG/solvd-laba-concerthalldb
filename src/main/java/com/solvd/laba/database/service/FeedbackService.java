package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.FeedbackDAO;
import com.solvd.laba.database.dao.FeedbackDAOImpl;
import com.solvd.laba.database.interfaces.IFeedbackService;
import com.solvd.laba.database.model.Feedback;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The FeedbackService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class FeedbackService implements IFeedbackService {
    private final FeedbackDAO feedbackDAO;

    public FeedbackService() {
        this.feedbackDAO = new FeedbackDAOImpl();
    }

    public Feedback getFeedbackById(int feedbackId) {
        try {
            return feedbackDAO.get(feedbackId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Feedback> getFeedbacks() {
        try {
            return feedbackDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void setFeedback(Feedback feedback) {
        try {
            feedbackDAO.insert(feedback);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateFeedback(Feedback feedback) {
        try {
            feedbackDAO.update(feedback);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteFeedback(Feedback feedback) {
        try {
            feedbackDAO.delete(feedback);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
