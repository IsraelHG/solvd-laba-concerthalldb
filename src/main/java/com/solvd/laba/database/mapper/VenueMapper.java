package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Venue;

import java.util.ArrayList;

public interface VenueMapper {
    /**
     * Retrieves venue from the database based on the provided ID.
     *
     * @param id the ID of the venue
     * @return the venue object if found, null otherwise
     */
    Venue getVenueById(int id);

    ArrayList<Venue> getVenues();

    /**
     * Inserts new venue into the database.
     *
     * @param venue the venue object to be inserted
     */
    void insertVenue(Venue venue);

    /**
     * Updates existing venue in the database.
     *
     * @param venue the venue object to be updated
     */
    void updateVenue(Venue venue);

    /**
     * Deletes venue from the database based on the provided venue object.
     *
     * @param venue the object of the venue to be deleted
     */
    void deleteVenue(Venue venue);
}
