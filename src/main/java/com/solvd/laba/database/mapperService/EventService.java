package com.solvd.laba.database.mapperService;

import com.solvd.laba.database.Database;
import com.solvd.laba.database.mapper.EventMapper;
import com.solvd.laba.database.model.Event;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.Connection;
import java.sql.SQLException;


public class EventService {
    private final EventMapper eventMapper;

    public EventService(SqlSessionFactory sqlSessionFactory) {
        this.eventMapper = sqlSessionFactory.openSession().getMapper(EventMapper.class);
    }

    public Event getEventById(int id) {
        return eventMapper.selectEventById(id);
    }

    public void setArtist(Event event) {
        eventMapper.insertEvent(event);
    }

    public void updateArtist(Event event) {
        eventMapper.updateEvent(event);
    }

    public void deleteEventById(int id) {
        eventMapper.deleteEventById(id);
    }
}
