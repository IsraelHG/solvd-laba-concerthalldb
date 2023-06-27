package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Sponsor;

import java.util.ArrayList;

public interface SponsorMapper {
    /**
     * Retrieves a sponsor from the database based on the provided ID.
     *
     * @param id the ID of the sponsor
     * @return the sponsor object if found, null otherwise
     */
    Sponsor getSponsorById(int id);

    ArrayList<Sponsor> getSponsors();

    /**
     * Inserts a new sponsor into the database.
     *
     * @param sponsor the sponsor object to be inserted
     */
    void insertSponsor(Sponsor sponsor);

    /**
     * Updates an existing sponsor in the database.
     *
     * @param sponsor the sponsor object to be updated
     */
    void updateSponsor(Sponsor sponsor);

    /**
     * Deletes a sponsor from the database based on the provided sponsor object.
     *
     * @param sponsor the object of the sponsor to be deleted
     */
    void deleteSponsor(Sponsor sponsor);
}
