package com.solvd.laba.database.service;

import com.solvd.laba.database.interfaces.IEventService;
import com.solvd.laba.database.mapper.EventMapper;
import com.solvd.laba.database.model.Event;
import com.solvd.laba.database.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class EventServiceMyBatis implements IEventService {
    private final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public EventServiceMyBatis() {}

    public Event getEventById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EventMapper eventMapper = session.getMapper(EventMapper.class);
            return eventMapper.getEventById(id);
        }
    }

    public ArrayList<Event> getEvents() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EventMapper eventMapper = session.getMapper(EventMapper.class);
            return eventMapper.getEvents();
        }
    }

    public void setEvent(Event event) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EventMapper eventMapper = session.getMapper(EventMapper.class);
            eventMapper.insertEvent(event);
        }
    }

    public void updateEvent(Event event) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EventMapper eventMapper = session.getMapper(EventMapper.class);
            eventMapper.updateEvent(event);
        }
    }

    public void deleteEvent(Event event) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EventMapper eventMapper = session.getMapper(EventMapper.class);
            eventMapper.deleteEvent(event);
        }
    }
}
