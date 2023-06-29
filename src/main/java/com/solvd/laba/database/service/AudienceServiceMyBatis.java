package com.solvd.laba.database.service;

import com.solvd.laba.database.interfaces.IAudienceService;
import com.solvd.laba.database.mapper.AudienceMapper;
import com.solvd.laba.database.model.Audience;
import com.solvd.laba.database.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class AudienceServiceMyBatis implements IAudienceService {
    private final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public AudienceServiceMyBatis() {}

    public Audience getAudienceById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AudienceMapper audienceMapper = session.getMapper(AudienceMapper.class);
            return audienceMapper.getAudienceById(id);
        }
    }

    public Audience getAudienceByName(String audienceName) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AudienceMapper audienceMapper = session.getMapper(AudienceMapper.class);
            return audienceMapper.getAudienceByName(audienceName);
        }
    }

    public Audience getAudienceByEmail(String email) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AudienceMapper audienceMapper = session.getMapper(AudienceMapper.class);
            return audienceMapper.getAudienceByEmail(email);
        }
    }

    public ArrayList<Audience> getAudiences() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AudienceMapper audienceMapper = session.getMapper(AudienceMapper.class);
            return audienceMapper.getAudiences();
        }
    }

    public void setAudience(Audience audience) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            AudienceMapper audienceMapper = session.getMapper(AudienceMapper.class);
            audienceMapper.insertAudience(audience);
        }
    }

    public void updateAudience(Audience audience) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            AudienceMapper audienceMapper = session.getMapper(AudienceMapper.class);
            audienceMapper.updateAudience(audience);
        }
    }

    public void deleteAudience(Audience audience) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            AudienceMapper audienceMapper = session.getMapper(AudienceMapper.class);
            audienceMapper.deleteAudience(audience);
        }
    }
}
