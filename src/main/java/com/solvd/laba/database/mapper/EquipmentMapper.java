package com.solvd.laba.database.mapper;

import com.solvd.laba.database.model.Equipment;

import java.util.ArrayList;

public interface EquipmentMapper {
    /**
     * Retrieves equipment from the database based on the provided ID.
     *
     * @param id the ID of the equipment
     * @return the equipment object if found, null otherwise
     */
    Equipment getEquipmentById(int id);

    /**
     * Retrieves all equipments from the database.
     *
     * @return a collection of equipments if found, null otherwise
     */
    ArrayList<Equipment> getEquipments();

    /**
     * Inserts new equipment into the database.
     *
     * @param equipment the equipment object to be inserted
     */
    void insertEquipment(Equipment equipment);

    /**
     * Updates existing equipment in the database.
     *
     * @param equipment the equipment object to be updated
     */
    void updateEquipment(Equipment equipment);

    /**
     * Deletes equipment from the database based on the provided equipment object.
     *
     * @param equipment the object of the equipment to be deleted
     */
    void deleteEquipment(Equipment equipment);
}
