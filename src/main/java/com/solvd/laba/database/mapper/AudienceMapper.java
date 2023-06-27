package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Audience;

import java.util.ArrayList;

public interface AudienceMapper {
    /**
     * Retrieves audience from the database based on the provided ID.
     *
     * @param id the ID of the audience
     * @return the audience object if found, null otherwise
     */
    Audience getAudienceById(int id);

    /**
     * Retrieves audience from the database based on the provided first name.
     *
     * @param audienceName the first name of the audience
     * @return the audience object if found, null otherwise
     */
    Audience getAudienceByName(String audienceName);

    /**
     * Retrieves audience from the database based on the provided email.
     *
     * @param email the email of the audience
     * @return the audience object if found, null otherwise
     */
    Audience getAudienceByEmail(String email);

    /**
     * Retrieves all audiences from the database.
     *
     * @return a collection of audiences if found, null otherwise
     */
    ArrayList<Audience> getAudiences();

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
     * Deletes audience from the database based on the provided audience object.
     *
     * @param audience the object of the audience to be deleted
     */
    void deleteAudience(Audience audience);
}
