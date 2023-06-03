package com.solvd.laba.database;

import com.solvd.laba.database.interfaces.VenuesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VenuesDAOImpl implements VenuesDAO {

    @Override
    public Venues get(int id) throws SQLException {
        Connection con = Database.getConnection();
        Venues venues = null;
        String sql = "SELECT * FROM venues WHERE venue_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int venueId = rs.getInt("venue_id");
            String name = rs.getString("name");
            String city = rs.getString("city");
            String state = rs.getString("state");
            int capacity = rs.getInt("capacity");
            String website = rs.getString("website");

            venues = new Venues(venueId, name, city, state, capacity, website);
        }
        return venues;
    }


    @Override
    public ArrayList<Venues> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Venues venues) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Venues venues) throws SQLException {
        return 0;
    }

    @Override
    public int update(Venues venues) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Venues venues) {
        return 0;
    }
}
