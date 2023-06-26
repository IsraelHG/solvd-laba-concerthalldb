package com.solvd.laba.database.interfaces;

import com.solvd.laba.database.model.Staff;

import java.util.ArrayList;


/**
 * The IStaffService interface provides a contract for accessing and manipulating staff data.
 * It defines methods for retrieving, inserting, updating, and deleting staff objects.
 */
public interface IStaffService {
    /**
     * Retrieves staff with the specified ID.
     *
     * @param id the ID of the staff to retrieve
     * @return the staff object with the specified ID, or null if not found
     */
    Staff getStaffById(int id);

    /**
     * Retrieves a list of all staffs.
     *
     * @return an ArrayList containing all staffs
     */
    ArrayList<Staff> getStaffs();

    /**
     * Inserts new staff into the database.
     *
     * @param staff the staff object to insert
     */
    void setStaff(Staff staff);

    /**
     * Updates existing staff in the database.
     *
     * @param staff the staff object to update
     */
    void updateStaff(Staff staff);

    /**
     * Deletes a staff from the database.
     *
     * @param staff the staff object to delete
     */
    void deleteStaff(Staff staff);
}
