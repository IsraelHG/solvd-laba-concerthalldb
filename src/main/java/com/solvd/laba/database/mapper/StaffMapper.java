package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Staff;

import java.util.ArrayList;

public interface StaffMapper {
    /**
     * Retrieves staff from the database based on the provided ID.
     *
     * @param id the ID of the staff
     * @return the staff object if found, null otherwise
     */
    Staff getStaffById(int id);

    ArrayList<Staff> getStaffs();

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
     * Deletes staff from the database based on the provided staff object.
     *
     * @param staff the object of the staff to be deleted
     */
    void deleteStaff(Staff staff);
}
