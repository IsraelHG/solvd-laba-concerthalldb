package com.solvd.laba.database.service;

import com.solvd.laba.database.interfaces.IFeedbackService;
import com.solvd.laba.database.mapper.FeedbackMapper;
import com.solvd.laba.database.model.Feedback;
import com.solvd.laba.database.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class FeedbackServiceMyBatis implements IFeedbackService {
    private final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public FeedbackServiceMyBatis() {}

    public Feedback getFeedbackById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            FeedbackMapper feedbackMapper = session.getMapper(FeedbackMapper.class);
            return feedbackMapper.getFeedbackById(id);
        }
    }

    public ArrayList<Feedback> getFeedbacks() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            FeedbackMapper feedbackMapper = session.getMapper(FeedbackMapper.class);
            return feedbackMapper.getFeedbacks();
        }
    }

    public void setFeedback(Feedback feedback) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            FeedbackMapper feedbackMapper = session.getMapper(FeedbackMapper.class);
            feedbackMapper.insertFeedback(feedback);
        }
    }

    public void updateFeedback(Feedback feedback) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            FeedbackMapper feedbackMapper = session.getMapper(FeedbackMapper.class);
            feedbackMapper.updateFeedback(feedback);
        }
    }

    public void deleteFeedback(Feedback feedback) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            FeedbackMapper feedbackMapper = session.getMapper(FeedbackMapper.class);
            feedbackMapper.deleteFeedback(feedback);
        }
    }
}
