package com.solvd.laba.database.service;

import com.solvd.laba.database.interfaces.IArtistService;
import com.solvd.laba.database.mapper.ArtistMapper;
import com.solvd.laba.database.model.Artist;
import com.solvd.laba.database.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class ArtistServiceMyBatis implements IArtistService {
    private final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public ArtistServiceMyBatis() {}

    @Override
    public Artist getArtistById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ArtistMapper artistMapper = session.getMapper(ArtistMapper.class);
            return artistMapper.getArtistById(id);
        }
    }

    @Override
    public ArrayList<Artist> getArtists() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ArtistMapper artistMapper = session.getMapper(ArtistMapper.class);
            return artistMapper.getArtists();
        }
    }

    @Override
    public void setArtist(Artist artist) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            ArtistMapper artistMapper = session.getMapper(ArtistMapper.class);
            artistMapper.insertArtist(artist);
        }
    }

    @Override
    public void updateArtist(Artist artist) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            ArtistMapper artistMapper = session.getMapper(ArtistMapper.class);
            artistMapper.updateArtist(artist);
        }
    }

    @Override
    public void deleteArtist(Artist artist) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            ArtistMapper artistMapper = session.getMapper(ArtistMapper.class);
            artistMapper.deleteArtist(artist);
        }
    }

    public List<Artist> getArtistsByName(String name) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ArtistMapper artistMapper = session.getMapper(ArtistMapper.class);
            return artistMapper.selectArtistByName(name);
        }
    }

    public List<Artist> getArtistsByGenre(String genre) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ArtistMapper artistMapper = session.getMapper(ArtistMapper.class);
            return artistMapper.selectArtistsByGenre(genre);
        }
    }

    public List<Map<String, Object>> getArtistConcertCounts() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ArtistMapper artistMapper = session.getMapper(ArtistMapper.class);
            return artistMapper.getArtistConcertCounts();
        }
    }
}
