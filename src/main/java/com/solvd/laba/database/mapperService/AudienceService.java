package com.solvd.laba.database.mapperService;

import com.solvd.laba.database.mapper.AudienceMapper;
import com.solvd.laba.database.model.Audience;
import org.apache.ibatis.session.SqlSessionFactory;

public class AudienceService {
    private final AudienceMapper audienceMapper;

    public AudienceService(SqlSessionFactory sqlSessionFactory) {
        this.audienceMapper = sqlSessionFactory.openSession().getMapper(AudienceMapper.class);
    }

    public Audience getAudienceById(int id) {
        return audienceMapper.selectAudienceById(id);
    }

    public void setAudience(Audience audience) {
        audienceMapper.insertAudience(audience);
    }

    public void updateAudience(Audience audience) {
        audienceMapper.updateAudience(audience);
    }

    public void deleteAudienceById(int id) {
        audienceMapper.deleteAudienceById(id);
    }
}
