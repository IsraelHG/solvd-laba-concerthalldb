package com.solvd.laba.database.mapperService;

import com.solvd.laba.database.mapper.VenueMapper;
import com.solvd.laba.database.model.Venue;
import org.apache.ibatis.session.SqlSessionFactory;

public class VenueService {
    private final VenueMapper venueMapper;

    public VenueService(SqlSessionFactory sqlSessionFactory) {
        this.venueMapper = sqlSessionFactory.openSession().getMapper(VenueMapper.class);
    }

    public Venue getVenueById(int id) {
        return venueMapper.selectVenueById(id);
    }

    public void setVenue(Venue venue) {
        venueMapper.insertVenue(venue);
    }

    public void updateVenue(Venue venue) {
        venueMapper.updateVenue(venue);
    }

    public void deleteVenueById(int id) {
        venueMapper.deleteVenueById(id);
    }
}
