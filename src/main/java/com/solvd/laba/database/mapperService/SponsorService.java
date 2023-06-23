package com.solvd.laba.database.mapperService;

import com.solvd.laba.database.mapper.SponsorMapper;
import com.solvd.laba.database.model.Sponsor;
import org.apache.ibatis.session.SqlSessionFactory;

public class SponsorService {
    private final SponsorMapper sponsorMapper;

    public SponsorService(SqlSessionFactory sqlSessionFactory) {
        this.sponsorMapper = sqlSessionFactory.openSession().getMapper(SponsorMapper.class);
    }

    public Sponsor getSponsorById(int id) {
        return sponsorMapper.selectSponsorById(id);
    }

    public void setSponsor(Sponsor sponsor) {
        sponsorMapper.insertSponsor(sponsor);
    }

    public void updateSponsor(Sponsor sponsor) {
        sponsorMapper.updateSponsor(sponsor);
    }

    public void deleteSponsorById(int id) {
        sponsorMapper.deleteSponsorById(id);
    }
}
