package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.StaffDAO;
import com.solvd.laba.database.dao.StaffDAOImpl;
import com.solvd.laba.database.interfaces.IStaffService;
import com.solvd.laba.database.model.Staff;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The StaffService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class StaffService implements IStaffService {
    private final StaffDAO staffDAO;

    public StaffService() {
        this.staffDAO = new StaffDAOImpl();
    }

    public Staff getStaffById(int id) {
        try {
            return staffDAO.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Staff> getStaffs() {
        try {
            return staffDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setStaff(Staff staff) {
        try {
            staffDAO.insert(staff);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStaff(Staff staff) {
        try {
            staffDAO.update(staff);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteStaff(Staff staff) {
        try {
            staffDAO.delete(staff);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
