package com.solvd.laba.database.service;

import com.solvd.laba.database.interfaces.IStaffService;
import com.solvd.laba.database.mapper.StaffMapper;
import com.solvd.laba.database.model.Staff;
import com.solvd.laba.database.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class StaffServiceMyBatis implements IStaffService {
    private final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public StaffServiceMyBatis() {}

    public Staff getStaffById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);
            return staffMapper.getStaffById(id);
        }
    }

    public ArrayList<Staff> getStaffs() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);
            return staffMapper.getStaffs();
        }
    }

    public void setStaff(Staff staff) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);
            staffMapper.insertStaff(staff);
        }
    }

    public void updateStaff(Staff staff) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);
            staffMapper.updateStaff(staff);
        }
    }

    public void deleteStaff(Staff staff) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);
            staffMapper.deleteStaff(staff);
        }
    }
}
