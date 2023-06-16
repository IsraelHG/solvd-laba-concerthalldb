package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.Audience;
import com.solvd.laba.database.model.Event;
import com.solvd.laba.database.model.Feedback;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * The FeedbackDAOImpl class is an implementation of the FeedbackDAO interface that provides
 * methods to interact with the Feedbacks table in the database using JDBC.
 */
public class FeedbackDAOImpl extends BaseDAOImpl<Feedback> implements FeedbackDAO {
    private static final String FEEDBACK_ID = "feedback_id";
    private static final String FK_EVENT_ID = "event_id";
    private static final String FK_AUDIENCE_ID = "audience_id";
    private static final String RATING = "rating";
    private static final String TABLE_NAME = "Feedbacks";
    @Override
    protected Feedback mapRow(ResultSet resultSet) throws SQLException {
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(resultSet.getInt(FEEDBACK_ID));

        //----------------------------------------
        // Retrieves the event id from the feedback table, which will then
        // be mapped to its corresponding object, and set it in the feedback class.
        int eventId = resultSet.getInt(FK_EVENT_ID);
        Event event = fetchEventForFeedback(eventId);
        feedback.setEvent(event);

        // Retrieves the audience id from the feedback table, which will then
        // be mapped to its corresponding object, and set it in the feedback class.
        int audienceId = resultSet.getInt(FK_AUDIENCE_ID);
        Audience audience = fetchAudienceForFeedback(audienceId);
        feedback.setAudience(audience);

        feedback.setRating(resultSet.getInt(RATING));
        return feedback;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected String getIdColumnName() {
        return FEEDBACK_ID;
    }

    @Override
    protected int getId(Feedback entity) {
        return entity.getFeedbackId();
    }

    @Override
    protected String getInsertValues(Feedback entity) {
        return "(" + FK_EVENT_ID + ", " + FK_AUDIENCE_ID  + ", " + RATING + ") VALUES ('" +
                entity.getEvent().getEventId() + "', '" + entity.getAudience().getAudienceId() + "', '" + entity.getRating() + "');";
    }

    @Override
    protected String getUpdateValues(Feedback entity) {
        return FK_EVENT_ID + "='" + entity.getEvent().getEventId() + "', " +
                FK_AUDIENCE_ID + "='" + entity.getAudience().getAudienceId() + "', " +
                RATING + "='" + entity.getRating() + "');";
    }

    @Override
    public Event fetchEventForFeedback(int eventId) throws SQLException {
        EventDAO eventDAO = new EventDAOImpl();
        return eventDAO.get(eventId);
    }

    @Override
    public Audience fetchAudienceForFeedback(int audienceId) throws SQLException {
        AudienceDAO audienceDAO = new AudienceDAOImpl();
        return audienceDAO.get(audienceId);
    }
}
