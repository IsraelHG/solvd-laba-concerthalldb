package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.EquipmentDAO;
import com.solvd.laba.database.dao.EquipmentDAOImpl;
import com.solvd.laba.database.model.Equipment;

import java.sql.SQLException;

/**
 * The EquipmentService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class EquipmentService {
    private final EquipmentDAO equipmentDAO;

    public EquipmentService() {
        equipmentDAO = new EquipmentDAOImpl();
    }

    /**
     * Retrieves equipment with the specified ID along with its associated equipment.
     *
     * @param equipmentId the ID of the equipment to retrieve
     * @return the equipment object with the specified ID
     * @throws SQLException if an error occurs while accessing the database
     */
    public Equipment getEquipment(int equipmentId) throws SQLException {
        return equipmentDAO.get(equipmentId);
    }

    /**
     * Sets an equipment and inserts it into the database along with its credentials.
     *
     * @param equipment equipment object to be pushed into the server
     * @throws SQLException if an error occurs while accessing the database
     */
    public void setEquipment(Equipment equipment) throws SQLException {
        equipmentDAO.insert(equipment);
    }

    /**
     * Saves an equipment object in the database. This method is used for either inserting a new equipment or updating an existing one.
     *
     * @param equipment the equipment object to save
     * @throws SQLException if an error occurs while accessing the database
     */
    public void saveEquipment(Equipment equipment) throws SQLException {
        equipmentDAO.save(equipment);
    }

    /**
     * Deletes an equipment object from the database.
     *
     * @param equipment the equipment object to delete
     * @throws SQLException if an error occurs while accessing the database
     */
    public void deleteEquipment(Equipment equipment) throws SQLException {
        equipmentDAO.delete(equipment);
    }
}
