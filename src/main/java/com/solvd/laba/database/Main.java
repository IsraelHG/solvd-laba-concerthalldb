package com.solvd.laba.database;

import com.solvd.laba.database.interfaces.VenuesDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        VenuesDAO venuesDAO = new VenuesDAOImpl();
        try {
            Venues venues = venuesDAO.get(1);
            System.out.println(venues);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
