package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.SponsorDAO;
import com.solvd.laba.database.dao.SponsorDAOImpl;
import com.solvd.laba.database.model.Sponsor;

import java.sql.SQLException;

/**
 * The SponsorService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class SponsorService {
    private final SponsorDAO sponsorDAO;

    public SponsorService() {
        sponsorDAO = new SponsorDAOImpl();
    }

    /**
     * Retrieves an event with the specified ID along with its associated venues.
     *
     * @param sponsorId the ID of the sponsor to retrieve
     * @return the event object with the specified ID
     * @throws SQLException if an error occurs while accessing the database
     */
    public Sponsor getSponsor(int sponsorId) throws SQLException {
        return sponsorDAO.get(sponsorId);
    }

    /**
     * Sets a sponsor and inserts it into the database along with its credentials.
     *
     * @param sponsor sponsor object to be pushed into the server
     * @throws SQLException if an error occurs while accessing the database
     */
    public void setSponsor(Sponsor sponsor) throws SQLException {
        sponsorDAO.insert(sponsor);
    }

    /**
     * Saves a sponsor object in the database. This method is used for either inserting a new sponsor or updating an existing one.
     *
     * @param sponsor the sponsor object to save
     * @throws SQLException if an error occurs while accessing the database
     */
    public void saveSponsor(Sponsor sponsor) throws SQLException {
        sponsorDAO.save(sponsor);
    }

    /**
     * Deletes a sponsor object from the database.
     *
     * @param sponsor the sponsor object to delete
     * @throws SQLException if an error occurs while accessing the database
     */
    public void deleteSponsor(Sponsor sponsor) throws SQLException {
        sponsorDAO.delete(sponsor);
    }
}
