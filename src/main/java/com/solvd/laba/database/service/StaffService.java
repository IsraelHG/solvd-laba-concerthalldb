package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.StaffDAO;
import com.solvd.laba.database.dao.StaffDAOImpl;
import com.solvd.laba.database.model.Staff;

import java.sql.SQLException;

/**
 * The StaffService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class StaffService {
    private final StaffDAO staffDAO;

    public StaffService() {
        this.staffDAO = new StaffDAOImpl();
    }

    /**
     * Retrieves a staff with the specified ID.
     *
     * @param staffId the ID of the staff to retrieve
     * @return the staff object with the specified ID
     * @throws SQLException if an error occurs while accessing the database
     */
    public Staff getStaff(int staffId) throws SQLException {
        return staffDAO.get(staffId);
    }

    /**
     * Sets a staff and inserts it into the database along with its credentials.
     *
     * @param staff staff object to be pushed into the server
     * @throws SQLException if an error occurs while accessing the database
     */
    public void setStaff(Staff staff) throws SQLException {
        staffDAO.insert(staff);
    }

    /**
     * Saves a staff object in the database. This method is used for either inserting a new staff or updating an existing one.
     *
     * @param staff the staff object to save
     * @throws SQLException if an error occurs while accessing the database
     */
    public void saveStaff(Staff staff) throws SQLException {
        staffDAO.save(staff);
    }

    /**
     * Deletes a staff object from the database.
     *
     * @param staff the staff object to delete
     * @throws SQLException if an error occurs while accessing the database
     */
    public void deleteStaff(Staff staff) throws SQLException {
        staffDAO.delete(staff);
    }
}
