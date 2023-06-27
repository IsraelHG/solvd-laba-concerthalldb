package com.solvd.laba.database.interfaces;

import com.solvd.laba.database.model.Artist;

import java.util.ArrayList;

/**
 * The IArtistService interface provides a contract for accessing and manipulating artist data.
 * It defines methods for retrieving, inserting, updating, and deleting artist objects.
 */
public interface IArtistService {

    /**
     * Retrieves an artist with the specified ID.
     *
     * @param id the ID of the artist to retrieve
     * @return the artist object with the specified ID, or null if not found
     */
    Artist getArtistById(int id);

    /**
     * Retrieves a list of all artists.
     *
     * @return an ArrayList containing all artists
     */
    ArrayList<Artist> getArtists();

    /**
     * Inserts a new artist into the database.
     *
     * @param artist the artist object to insert
     */
    void setArtist(Artist artist);

    /**
     * Updates an existing artist in the database.
     *
     * @param artist the artist object to update
     */
    void updateArtist(Artist artist);

    /**
     * Deletes an artist from the database.
     *
     * @param artist the artist object to delete
     */
    void deleteArtist(Artist artist);
}
