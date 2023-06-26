package com.solvd.laba.database.dao;

import com.solvd.laba.database.enums.Gender;
import com.solvd.laba.database.model.Audience;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The AudienceDAOImpl class is an implementation of the AudienceDAO interface that provides
 * methods to interact with the Audiences table in the database using JDBC.
 */
public class AudienceDAOImpl extends BaseDAOImpl<Audience> implements AudienceDAO {
    private static final String AUDIENCE_ID = "audience_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String AGE = "age";
    private static final String GENDER = "gender";
    private static final String EMAIL = "email";
    private static final String TABlE_NAME = "audiences";
    @Override
    protected Audience mapRow(ResultSet resultSet) throws SQLException {
        Audience audience = new Audience();
        audience.setAudienceId(resultSet.getInt(AUDIENCE_ID));
        audience.setFirstName(resultSet.getString(FIRST_NAME));
        audience.setLastName(resultSet.getString(LAST_NAME));
        audience.setAge(resultSet.getInt(AGE));
        String gender = resultSet.getString(GENDER);
        switch(gender) {
            case "Male" -> audience.setGender(Gender.MALE);
            case "Female" -> audience.setGender(Gender.FEMALE);
            default -> audience.setGender(Gender.OTHER);
        }
        audience.setEmail(resultSet.getString(EMAIL));
        return audience;
    }

    @Override
    protected String getTableName() {
        return TABlE_NAME;
    }

    @Override
    protected String getIdColumnName() {
        return AUDIENCE_ID;
    }

    @Override
    protected int getId(Audience entity) {
        return entity.getAudienceId();
    }

    @Override
    protected String getInsertValues(Audience entity) {
        return "(" + FIRST_NAME + ", " + LAST_NAME  + ", " + AGE  + ", " + GENDER  + ", " + EMAIL  + ") VALUES ('" +
                entity.getFirstName() + "', '" + entity.getLastName() + "', '" + entity.getAge() + "', '" +
                entity.getGender() + "', '" + entity.getEmail() + "');";
    }

    @Override
    protected String getUpdateValues(Audience entity) {
        return FIRST_NAME + "='" + entity.getFirstName() + "', " +
                LAST_NAME + "='" + entity.getLastName() + "', " +
                AGE + "='" + entity.getAge() + "', " +
                GENDER + "='" + entity.getGender() + "', " +
                EMAIL + "='" + entity.getEmail() + "');";
    }
}
