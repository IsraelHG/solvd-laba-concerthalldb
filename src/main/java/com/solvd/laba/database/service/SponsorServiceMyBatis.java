package com.solvd.laba.database.service;

import com.solvd.laba.database.interfaces.ISponsorService;
import com.solvd.laba.database.mapper.SponsorMapper;
import com.solvd.laba.database.model.Sponsor;
import com.solvd.laba.database.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class SponsorServiceMyBatis implements ISponsorService {
    private final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public SponsorServiceMyBatis() {}

    public Sponsor getSponsorById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SponsorMapper sponsorMapper = session.getMapper(SponsorMapper.class);
            return sponsorMapper.getSponsorById(id);
        }
    }

    public ArrayList<Sponsor> getSponsors() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SponsorMapper sponsorMapper = session.getMapper(SponsorMapper.class);
            return sponsorMapper.getSponsors();
        }
    }

    public void setSponsor(Sponsor sponsor) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            SponsorMapper sponsorMapper = session.getMapper(SponsorMapper.class);
            sponsorMapper.insertSponsor(sponsor);
        }
    }

    public void updateSponsor(Sponsor sponsor) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            SponsorMapper sponsorMapper = session.getMapper(SponsorMapper.class);
            sponsorMapper.updateSponsor(sponsor);
        }
    }

    public void deleteSponsor(Sponsor sponsor) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            SponsorMapper sponsorMapper = session.getMapper(SponsorMapper.class);
            sponsorMapper.deleteSponsor(sponsor);
        }
    }
}
