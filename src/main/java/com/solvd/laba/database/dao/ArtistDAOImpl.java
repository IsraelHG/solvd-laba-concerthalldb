package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.Artist;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistDAOImpl extends BaseDAOImpl<Artist> implements ArtistDAO {
    private static final String ARTIST_ID = "artist_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String GENRE = "genre";
    private static final String EMAIL = "email";
    private static final String TABLE_NAME = "Artists";
    @Override
    protected Artist mapRow(ResultSet resultSet) throws SQLException {
        Artist artist = new Artist();
        artist.setArtistId(resultSet.getInt(ARTIST_ID));
        artist.setFirstName(resultSet.getString(FIRST_NAME));
        artist.setLastName(resultSet.getString(LAST_NAME));
        artist.setGenre(resultSet.getString(GENRE));
        artist.setEmail(resultSet.getString(EMAIL));
        return artist;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected String getIdColumnName() {
        return ARTIST_ID;
    }

    @Override
    protected int getId(Artist entity) {
        return entity.getArtistId();
    }

    @Override
    protected String getInsertValues(Artist entity) {
        return "(" + FIRST_NAME + ", " + LAST_NAME + ", " + GENRE + ", " + EMAIL + ") VALUES ('" +
                entity.getFirstName() + "', '" + entity.getLastName() + "', '" + entity.getGenre() + "', '" +
                entity.getEmail() + "');";
    }

    @Override
    protected String getUpdateValues(Artist entity) {
        return ARTIST_ID + "='" + entity.getArtistId() + "', " +
                FIRST_NAME + "='" + entity.getFirstName() + "', " +
                LAST_NAME + "='" + entity.getLastName() + "', " +
                GENRE + "='" + entity.getGenre() + "', " +
                EMAIL + "='" + entity.getEmail() + "');";
    }
}
