package com.solvd.laba.database.service;

import com.solvd.laba.database.interfaces.IEquipmentService;
import com.solvd.laba.database.mapper.EquipmentMapper;
import com.solvd.laba.database.model.Equipment;
import com.solvd.laba.database.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class EquipmentServiceMyBatis implements IEquipmentService {
    private final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public EquipmentServiceMyBatis() {}

    public Equipment getEquipmentById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EquipmentMapper equipmentMapper = session.getMapper(EquipmentMapper.class);
            return equipmentMapper.getEquipmentById(id);
        }
    }

    public ArrayList<Equipment> getEquipments() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EquipmentMapper equipmentMapper = session.getMapper(EquipmentMapper.class);
            return equipmentMapper.getEquipments();
        }
    }

    public void setEquipment(Equipment equipment) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EquipmentMapper equipmentMapper = session.getMapper(EquipmentMapper.class);
            equipmentMapper.insertEquipment(equipment);
        }
    }

    public void updateEquipment(Equipment equipment) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EquipmentMapper equipmentMapper = session.getMapper(EquipmentMapper.class);
            equipmentMapper.updateEquipment(equipment);
        }
    }

    public void deleteEquipment(Equipment equipment) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            EquipmentMapper equipmentMapper = session.getMapper(EquipmentMapper.class);
            equipmentMapper.deleteEquipment(equipment);
        }
    }
}
