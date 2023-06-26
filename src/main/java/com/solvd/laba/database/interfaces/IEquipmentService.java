package com.solvd.laba.database.interfaces;

import com.solvd.laba.database.model.Equipment;

import java.util.ArrayList;


/**
 * The IEquipmentService interface provides a contract for accessing and manipulating equipment data.
 * It defines methods for retrieving, inserting, updating, and deleting equipment objects.
 */
public interface IEquipmentService {
    /**
     * Retrieves equipment with the specified ID.
     *
     * @param id the ID of the equipment to retrieve
     * @return the equipment object with the specified ID, or null if not found
     */
    Equipment getEquipmentById(int id);

    /**
     * Retrieves a list of all equipments.
     *
     * @return an ArrayList containing all equipments
     */
    ArrayList<Equipment> getEquipments();

    /**
     * Inserts new equipment into the database.
     *
     * @param equipment the equipment object to insert
     */
    void setEquipment(Equipment equipment);

    /**
     * Updates existing equipment in the database.
     *
     * @param equipment the equipment object to update
     */
    void updateEquipment(Equipment equipment);

    /**
     * Deletes an equipment from the database.
     *
     * @param equipment the equipment object to delete
     */
    void deleteEquipment(Equipment equipment);
}
