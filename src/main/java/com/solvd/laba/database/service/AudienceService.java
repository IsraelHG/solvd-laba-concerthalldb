package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.AudienceDAO;
import com.solvd.laba.database.dao.AudienceDAOImpl;
import com.solvd.laba.database.interfaces.IAudienceService;
import com.solvd.laba.database.model.Audience;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The AudienceService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class AudienceService implements IAudienceService {
    private final AudienceDAO audienceDAO;

    public AudienceService() {
        this.audienceDAO = new AudienceDAOImpl();
    }

    public Audience getAudienceById(int id) {
        try {
            return audienceDAO.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Audience> getAudiences() {
        try {
            return audienceDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setAudience(Audience audience) {
        try {
            audienceDAO.insert(audience);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAudience(Audience audience) {
        try {
            audienceDAO.update(audience);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteAudience(Audience audience) {
        try {
            audienceDAO.delete(audience);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
