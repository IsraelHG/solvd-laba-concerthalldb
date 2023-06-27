package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.VenueDAO;
import com.solvd.laba.database.dao.VenueDAOImpl;
import com.solvd.laba.database.interfaces.IVenueService;
import com.solvd.laba.database.model.Venue;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The VenueService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class VenueService implements IVenueService {
    private final VenueDAO venueDAO;

    public VenueService() {
        this.venueDAO = new VenueDAOImpl();
    }

    public Venue getVenueById(int id) {
        try {
            return venueDAO.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Venue> getVenues() {
        try {
            return venueDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setVenue(Venue venue) {
        try {
            venueDAO.insert(venue);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateVenue(Venue venue) {
        try {
            venueDAO.update(venue);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteVenue(Venue venue) {
        try {
            venueDAO.delete(venue);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
