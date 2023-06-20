package com.solvd.laba.database.mybatis;

import com.solvd.laba.database.mapper.ArtistMapper;
import com.solvd.laba.database.mapperService.ArtistService;
import com.solvd.laba.database.model.Artist;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MyBatisRunner {
    public static final Logger LOGGER = LogManager.getLogger(MyBatisRunner.class.getName());
    public static void main(String[] args) {
        // Get the SqlSessionFactory from MyBatisConfig
        SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

        // Open an SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ArtistMapper artistMapper = sqlSession.getMapper(ArtistMapper.class);
            ArtistService artistService = new ArtistService(artistMapper);

            // get - select by id
            Artist artist = artistService.getArtistById(1);
            LOGGER.info("Artist FROM DB: " + artist);

            // Insert
            //Artist artist1 = new Artist(100, "Artist", "Mapper", "Mapping", "artist.mapper@gmail.com");
            //artistService.setArtist(artist1);

            // Update
            //artist1.setArtistId(11);
            //artist1.setEmail("artist.new.mapper@gmail.com");
            //artistService.updateArtist(artist1);

            // delete
            //artistService.deleteArtistById(7);

            // selectArtistByName()
            String name = "Beyonce";
            List<Artist> artistsByName = artistService.getArtistsByName(name);
            LOGGER.info("Artists with the name " + name + ":");
            for (Artist a : artistsByName) {
                LOGGER.info(a);
            }

            // selectArtistsByGenre() method
            String genre = "Rock";
            List<Artist> artistsByGenre = artistService.getArtistsByGenre(genre);
            LOGGER.info("Artists in the genre " + genre + ":");
            for (Artist a : artistsByGenre) {
                LOGGER.info(a);
            }

            // getArtistConcertCounts() method
            List<Map<String, Object>> concertCounts = artistService.getArtistConcertCounts();

            // Process the results
            for (Map<String, Object> concertCount : concertCounts) {
                String artistName = (String) concertCount.get("first_name");
                Long totalConcerts = (Long) concertCount.get("total_concerts");

                LOGGER.info("Artist: " + artistName + ", Total Concerts: " + totalConcerts);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
