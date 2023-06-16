package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The StaffDAOImpl class is an implementation of the StaffDAO interface that provides
 * methods to interact with the Staffs table in the database using JDBC.
 */
public class StaffDAOImpl extends BaseDAOImpl<Staff> implements StaffDAO {
    private static final String STAFF_ID = "staff_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String ROLE = "role";
    private static final String TABLE_NAME = "Staffs";

    @Override
    protected Staff mapRow(ResultSet resultSet) throws SQLException {
        Staff staff = new Staff();
        staff.setStaffId(resultSet.getInt(STAFF_ID));
        staff.setFirstName(resultSet.getString(FIRST_NAME));
        staff.setLastName(resultSet.getString(LAST_NAME));
        staff.setRole(resultSet.getString(ROLE));
        return staff;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected String getIdColumnName() {
        return STAFF_ID;
    }

    @Override
    protected int getId(Staff entity) {
        return entity.getStaffId();
    }

    @Override
    protected String getInsertValues(Staff entity) {
        return "(" + FIRST_NAME + ", " + LAST_NAME  + ", " + ROLE + ") VALUES ('" +
                entity.getFirstName() + "', '" + entity.getLastName() + "', '" + entity.getRole() + "');";
    }

    @Override
    protected String getUpdateValues(Staff entity) {
        return FIRST_NAME + "='" + entity.getFirstName() + "', " +
                LAST_NAME + "='" + entity.getLastName() + "', " +
                ROLE + "='" + entity.getRole() + "');";
    }
}
