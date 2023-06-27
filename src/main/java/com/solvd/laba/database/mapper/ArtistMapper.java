package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ArtistMapper {

    /**
     * Retrieves an artist from the database based on the provided ID.
     *
     * @param id the ID of the artist
     * @return the artist object if found, null otherwise
     */
    Artist getArtistById(int id);

    /**
     * Retrieves all artists from the database.
     *
     * @return a collection of artists if found, null otherwise
     */
    ArrayList<Artist> getArtists();

    /**
     * Inserts a new artist into the database.
     *
     * @param artist the artist object to be inserted
     */
    void insertArtist(Artist artist);

    /**
     * Updates an existing artist in the database.
     *
     * @param artist the artist object to be updated
     */
    void updateArtist(Artist artist);

    /**
     * Deletes an artist from the database based on the provided artist object.
     *
     * @param artist the artist to be deleted
     */
    void deleteArtist(Artist artist);

    /**
     * Retrieves a list of artists from the database based on the provided name.
     *
     * @param name the name of the artist(s)
     * @return a list of artist objects matching the provided name
     */
    List<Artist> selectArtistByName(String name);

    /**
     * Retrieves a list of artists from the database based on the provided genre.
     *
     * @param genre the genre of the artist(s)
     * @return a list of artist objects matching the provided genre
     */
    List<Artist> selectArtistsByGenre(String genre);

    /**
     * Retrieves the total number of concerts performed by each artist.
     *
     * @return a list of maps containing the artist's first name and the total number of concerts
     */
    List<Map<String, Object>> getArtistConcertCounts();

}
