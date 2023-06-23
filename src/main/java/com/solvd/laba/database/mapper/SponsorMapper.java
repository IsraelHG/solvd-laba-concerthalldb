package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Sponsor;

public interface SponsorMapper {
    /**
     * Retrieves a sponsor from the database based on the provided ID.
     *
     * @param id the ID of the sponsor
     * @return the sponsor object if found, null otherwise
     */
    Sponsor selectSponsorById(int id);

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
     * Deletes a sponsor from the database based on the provided ID.
     *
     * @param id the ID of the sponsor to be deleted
     */
    void deleteSponsorById(int id);
}
