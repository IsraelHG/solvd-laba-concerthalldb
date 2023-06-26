package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Staff;

public interface StaffMapper {
    /**
     * Retrieves staff from the database based on the provided ID.
     *
     * @param id the ID of the staff
     * @return the staff object if found, null otherwise
     */
    Staff selectStaffById(int id);

    /**
     * Inserts new staff into the database.
     *
     * @param staff the staff object to be inserted
     */
    void insertStaff(Staff staff);

    /**
     * Updates existing staff in the database.
     *
     * @param staff the staff object to be updated
     */
    void updateStaff(Staff staff);

    /**
     * Deletes staff from the database based on the provided ID.
     *
     * @param id the ID of the staff to be deleted
     */
    void deleteStaffById(int id);
}
