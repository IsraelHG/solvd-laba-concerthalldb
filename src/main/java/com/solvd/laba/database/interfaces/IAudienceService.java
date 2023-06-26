package com.solvd.laba.database.interfaces;

import com.solvd.laba.database.model.Audience;

import java.util.ArrayList;


/**
 * The IAudienceService interface provides a contract for accessing and manipulating audience data.
 * It defines methods for retrieving, inserting, updating, and deleting audience objects.
 */
public interface IAudienceService {
    /**
     * Retrieves an audience with the specified ID.
     *
     * @param id the ID of the audience to retrieve
     * @return the audience object with the specified ID, or null if not found
     */
    Audience getAudienceById(int id);

    /**
     * Retrieves a list of all audiences.
     *
     * @return an ArrayList containing all audiences
     */
    ArrayList<Audience> getAudiences();

    /**
     * Inserts a new audience into the database.
     *
     * @param audience the audience object to insert
     */
    void setAudience(Audience audience);

    /**
     * Updates an existing audience in the database.
     *
     * @param audience the audience object to update
     */
    void updateAudience(Audience audience);

    /**
     * Deletes an audience from the database.
     *
     * @param audience the audience object to delete
     */
    void deleteAudience(Audience audience);
}
