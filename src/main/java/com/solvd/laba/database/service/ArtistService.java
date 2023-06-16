package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.ArtistDAO;
import com.solvd.laba.database.dao.ArtistDAOImpl;
import com.solvd.laba.database.model.Artist;

import java.sql.SQLException;

/**
 * The ArtistService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class ArtistService {
    private final ArtistDAO artistDAO;

    public ArtistService() {
        artistDAO = new ArtistDAOImpl();
    }
    /**
     * Retrieves artist with the specified ID along with its associated artist.
     *
     * @param artistId the ID of the artist to retrieve
     * @return the artist object with the specified ID
     * @throws SQLException if an error occurs while accessing the database
     */
    public Artist getArtist(int artistId) throws SQLException {
        return artistDAO.get(artistId);
    }

    /**
     * Sets an artist and inserts it into the database along with its credentials.
     *
     * @param artist artist object to be pushed into the server
     * @throws SQLException if an error occurs while accessing the database
     */
    public void setArist(Artist artist) throws SQLException {
        artistDAO.insert(artist);
    }

    /**
     * Saves an artist object in the database. This method is used for either inserting a new artist or updating an existing one.
     *
     * @param artist the artist object to save
     * @throws SQLException if an error occurs while accessing the database
     */
    public void saveArtist(Artist artist) throws SQLException {
        artistDAO.save(artist);
    }

    /**
     * Deletes an artist object from the database.
     *
     * @param artist the artist object to delete
     * @throws SQLException if an error occurs while accessing the database
     */
    public void deleteArtist(Artist artist) throws SQLException {
        artistDAO.delete(artist);
    }


}
