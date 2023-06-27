package com.solvd.laba.database.service;

import com.solvd.laba.database.dao.EquipmentDAO;
import com.solvd.laba.database.dao.EquipmentDAOImpl;
import com.solvd.laba.database.interfaces.IEquipmentService;
import com.solvd.laba.database.model.Equipment;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The EquipmentService class represents a high-level service to
 * access data from its database. It contains methods that are
 * meant to retrieve relevant information about its corresponding
 * entity object.
 */
public class EquipmentService implements IEquipmentService {
    private final EquipmentDAO equipmentDAO;

    public EquipmentService() {
        equipmentDAO = new EquipmentDAOImpl();
    }

    public Equipment getEquipmentById(int equipmentId) {
        try {
            return equipmentDAO.get(equipmentId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Equipment> getEquipments() {
        try {
            return equipmentDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void setEquipment(Equipment equipment) {
        try {
            equipmentDAO.insert(equipment);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEquipment(Equipment equipment) {
        try {
            equipmentDAO.update(equipment);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void deleteEquipment(Equipment equipment) {
        try {
            equipmentDAO.delete(equipment);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
