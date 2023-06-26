package com.solvd.laba.database.mapperService;

import com.solvd.laba.database.mapper.EquipmentMapper;
import com.solvd.laba.database.model.Equipment;
import org.apache.ibatis.session.SqlSessionFactory;

public class EquipmentService {
    private final EquipmentMapper equipmentMapper;

    public EquipmentService(SqlSessionFactory sqlSessionFactory) {
        this.equipmentMapper = sqlSessionFactory.openSession().getMapper(EquipmentMapper.class);
    }

    public Equipment getEquipmentById(int id) {
        return equipmentMapper.selectEquipmentById(id);
    }

    public void setEquipment(Equipment equipment) {
        equipmentMapper.insertEquipment(equipment);
    }

    public void updateEquipment(Equipment equipment) {
        equipmentMapper.updateEquipment(equipment);
    }

    public void deleteEquipmentById(int id) {
        equipmentMapper.deleteEquipmentById(id);
    }
}
