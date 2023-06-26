package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Audience;

public interface AudienceMapper {
    /**
     * Retrieves audience from the database based on the provided ID.
     *
     * @param id the ID of the audience
     * @return the audience object if found, null otherwise
     */
    Audience selectAudienceById(int id);

    /**
     * Inserts new audience into the database.
     *
     * @param audience the audience object to be inserted
     */
    void insertAudience(Audience audience);

    /**
     * Updates existing audience in the database.
     *
     * @param audience the audience object to be updated
     */
    void updateAudience(Audience audience);

    /**
     * Deletes audience from the database based on the provided ID.
     *
     * @param id the ID of the audience to be deleted
     */
    void deleteAudienceById(int id);
}
