package com.solvd.laba.database.interfaces;

import com.solvd.laba.database.model.Venue;

import java.util.ArrayList;


/**
 * The IVenueService interface provides a contract for accessing and manipulating venue data.
 * It defines methods for retrieving, inserting, updating, and deleting venue objects.
 */
public interface IVenueService {
    /**
     * Retrieves venue with the specified ID.
     *
     * @param id the ID of the venue to retrieve
     * @return the venue object with the specified ID, or null if not found
     */
    Venue getVenueById(int id);

    /**
     * Retrieves a list of all venues.
     *
     * @return an ArrayList containing all venues
     */
    ArrayList<Venue> getVenues();

    /**
     * Inserts new venue into the database.
     *
     * @param venue the venue object to insert
     */
    void setVenue(Venue venue);

    /**
     * Updates existing venue in the database.
     *
     * @param venue the venue object to update
     */
    void updateVenue(Venue venue);

    /**
     * Deletes a venue from the database.
     *
     * @param venue the venue object to delete
     */
    void deleteVenue(Venue venue);
}
