package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.SponsorDAO;
import com.solvd.laba.database.dao.SponsorDAOImpl;
import com.solvd.laba.database.interfaces.ISponsorService;
import com.solvd.laba.database.model.Sponsor;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The SponsorService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class SponsorService implements ISponsorService {
    private final SponsorDAO sponsorDAO;

    public SponsorService() {
        this.sponsorDAO = new SponsorDAOImpl();
    }

    public Sponsor getSponsorById(int id) {
        try {
            return sponsorDAO.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Sponsor> getSponsors() {
        try {
            return sponsorDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setSponsor(Sponsor sponsor) {
        try {
            sponsorDAO.insert(sponsor);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSponsor(Sponsor sponsor) {
        try {
            sponsorDAO.update(sponsor);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteSponsor(Sponsor sponsor) {
        try {
            sponsorDAO.delete(sponsor);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
