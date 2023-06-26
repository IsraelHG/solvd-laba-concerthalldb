package com.solvd.laba.database.mapperService;

import com.solvd.laba.database.mapper.FeedbackMapper;
import com.solvd.laba.database.model.Feedback;
import org.apache.ibatis.session.SqlSessionFactory;

public class FeedbackService {
    private final FeedbackMapper feedbackMapper;

    public FeedbackService(SqlSessionFactory sqlSessionFactory) {
        this.feedbackMapper = sqlSessionFactory.openSession().getMapper(FeedbackMapper.class);
    }

    public Feedback getFeedbackById(int id) {
        return feedbackMapper.selectFeedbackById(id);
    }

    public void setFeedback(Feedback feedback) {
        feedbackMapper.insertFeedback(feedback);
    }

    public void updateFeedback(Feedback feedback) {
        feedbackMapper.updateFeedback(feedback);
    }

    public void deleteFeedbackById(int id) {
        feedbackMapper.deleteFeedbackById(id);
    }
}
