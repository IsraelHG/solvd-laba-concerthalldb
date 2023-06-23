package com.solvd.laba.database.mapperService;

import com.solvd.laba.database.mapper.ArtistMapper;
import com.solvd.laba.database.model.Artist;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
public class ArtistService {
    private final ArtistMapper artistMapper;

    public ArtistService(SqlSessionFactory sqlSessionFactory) {
        this.artistMapper = sqlSessionFactory.openSession().getMapper(ArtistMapper.class);
    }

    public Artist getArtistById(int id) {
        return artistMapper.selectArtistById(id);
    }

    public void setArtist(Artist artist) {
        artistMapper.insertArtist(artist);
    }

    public void updateArtist(Artist artist) {
        artistMapper.updateArtist(artist);
    }

    public void deleteArtistById(int id) {
        artistMapper.deleteArtistById(id);
    }

    public List<Artist> getArtistsByName(String name) {
        return artistMapper.selectArtistByName(name);
    }

    public List<Artist> getArtistsByGenre(String genre) {
        return artistMapper.selectArtistsByGenre(genre);
    }

    public List<Map<String, Object>> getArtistConcertCounts() {
        return artistMapper.getArtistConcertCounts();
    }
}
