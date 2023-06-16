package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.AudienceDAO;
import com.solvd.laba.database.dao.AudienceDAOImpl;
import com.solvd.laba.database.model.Audience;

import java.sql.SQLException;

/**
 * The AudienceService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class AudienceService {
    private final AudienceDAO audienceDAO;

    public AudienceService() {
        this.audienceDAO = new AudienceDAOImpl();
    }

    /**
     * Retrieves an audience with the specified ID.
     *
     * @param audienceId the ID of the audience to retrieve
     * @return the audience object with the specified ID
     * @throws SQLException if an error occurs while accessing the database
     */
    public Audience getAudience(int audienceId) throws SQLException {
        return audienceDAO.get(audienceId);
    }

    /**
     * Sets an audience and inserts it into the database along with its credentials.
     *
     * @param audience audience object to be pushed into the server
     * @throws SQLException if an error occurs while accessing the database
     */
    public void setAudience(Audience audience) throws SQLException {
        audienceDAO.insert(audience);
    }

    /**
     * Saves an audience object in the database. This method is used for either inserting a new audience or updating an existing one.
     *
     * @param audience the audience object to save
     * @throws SQLException if an error occurs while accessing the database
     */
    public void saveAudience(Audience audience) throws SQLException {
        audienceDAO.save(audience);
    }

    /**
     * Deletes an audience object from the database.
     *
     * @param audience the audience object to delete
     * @throws SQLException if an error occurs while accessing the database
     */
    public void deleteAudience(Audience audience) throws SQLException {
        audienceDAO.delete(audience);
    }
}
