package com.solvd.laba.database.mapperService;

import com.solvd.laba.database.mapper.StaffMapper;
import com.solvd.laba.database.model.Staff;
import org.apache.ibatis.session.SqlSessionFactory;

public class StaffService {
    private final StaffMapper staffMapper;

    public StaffService(SqlSessionFactory sqlSessionFactory) {
        this.staffMapper = sqlSessionFactory.openSession().getMapper(StaffMapper.class);
    }

    public Staff getStaffById(int id) {
        return staffMapper.selectStaffById(id);
    }

    public void setStaff(Staff staff) {
        staffMapper.insertStaff(staff);
    }

    public void updateStaff(Staff staff) {
        staffMapper.updateStaff(staff);
    }

    public void deleteStaffById(int id) {
        staffMapper.deleteStaffById(id);
    }
}
