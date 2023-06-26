package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.Equipment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipmentDAOImpl extends BaseDAOImpl<Equipment> implements EquipmentDAO {
    private static final String EQUIPMENT_ID = "equipment_id";
    private static final String NAME = "name";
    private static final String QUANTITY = "quantity";
    private static final String TABLE_NAME = "equipments";
    @Override
    protected Equipment mapRow(ResultSet resultSet) throws SQLException {
         Equipment equipment = new Equipment();
         equipment.setEquipmentId(resultSet.getInt(EQUIPMENT_ID));
         equipment.setName(resultSet.getString(NAME));
         equipment.setQuantity(resultSet.getInt(QUANTITY));
         return equipment;

    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected String getIdColumnName() {
        return EQUIPMENT_ID;
    }

    @Override
    protected int getId(Equipment entity) {
        return entity.getEquipmentId();
    }

    @Override
    protected String getInsertValues(Equipment entity) {
        return "(" + NAME + ", " + QUANTITY  + ") VALUES ('" +
                entity.getName() + "', '" + entity.getQuantity() + "');";
    }

    @Override
    protected String getUpdateValues(Equipment entity) {
        return "equipment_id='" + entity.getEquipmentId() + "', name='" + entity.getName() +
               "', quantity='" + entity.getQuantity() + "'";
    }
}
