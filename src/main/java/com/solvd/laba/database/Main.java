package com.solvd.laba.database;

import com.solvd.laba.database.dao.VenuesDAO;
import com.solvd.laba.database.dao.VenuesDAOImpl;
import com.solvd.laba.database.model.Venues;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) throws SQLException {

        VenuesDAO venuesDAO = new VenuesDAOImpl();
        try {
            Venues venue = venuesDAO.get(1);
            LOGGER.info(venue);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
