package com.solvd.laba.database.service;

import com.solvd.laba.database.interfaces.IVenueService;
import com.solvd.laba.database.mapper.VenueMapper;
import com.solvd.laba.database.model.Venue;
import com.solvd.laba.database.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class VenueServiceMyBatis implements IVenueService {
    private final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public VenueServiceMyBatis() {}

    public Venue getVenueById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            VenueMapper venueMapper = session.getMapper(VenueMapper.class);
            return venueMapper.getVenueById(id);
        }
    }

    public ArrayList<Venue> getVenues() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            VenueMapper venueMapper = session.getMapper(VenueMapper.class);
            return venueMapper.getVenues();
        }
    }

    public void setVenue(Venue venue) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            VenueMapper venueMapper = session.getMapper(VenueMapper.class);
            venueMapper.insertVenue(venue);
        }
    }

    public void updateVenue(Venue venue) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            VenueMapper venueMapper = session.getMapper(VenueMapper.class);
            venueMapper.updateVenue(venue);
        }
    }

    public void deleteVenue(Venue venue) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            VenueMapper venueMapper = session.getMapper(VenueMapper.class);
            venueMapper.deleteVenue(venue);
        }
    }
}
