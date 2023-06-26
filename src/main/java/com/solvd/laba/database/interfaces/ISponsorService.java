package com.solvd.laba.database.interfaces;

import com.solvd.laba.database.model.Sponsor;

import java.util.ArrayList;


/**
 * The ISponsorService interface provides a contract for accessing and manipulating sponsor data.
 * It defines methods for retrieving, inserting, updating, and deleting sponsor objects.
 */
public interface ISponsorService {
    /**
     * Retrieves sponsor with the specified ID.
     *
     * @param id the ID of the sponsor to retrieve
     * @return the sponsor object with the specified ID, or null if not found
     */
    Sponsor getSponsorById(int id);

    /**
     * Retrieves a list of all sponsors.
     *
     * @return an ArrayList containing all sponsors
     */
    ArrayList<Sponsor> getSponsors();

    /**
     * Inserts new sponsor into the database.
     *
     * @param sponsor the sponsor object to insert
     */
    void setSponsor(Sponsor sponsor);

    /**
     * Updates existing sponsor in the database.
     *
     * @param sponsor the sponsor object to update
     */
    void updateSponsor(Sponsor sponsor);

    /**
     * Deletes a sponsor from the database.
     *
     * @param sponsor the sponsor object to delete
     */
    void deleteSponsor(Sponsor sponsor);
}
