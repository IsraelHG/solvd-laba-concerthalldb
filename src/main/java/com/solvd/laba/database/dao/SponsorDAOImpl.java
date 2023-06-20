package com.solvd.laba.database.dao;

import com.solvd.laba.database.model.Sponsor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SponsorDAOImpl extends BaseDAOImpl<Sponsor> implements SponsorDAO {
    private static final String SPONSOR_ID = "sponsor_id";
    private static final String NAME = "name";
    private static final String SPONSORSHIP_AMOUNT = "sponsorship_amount";
    private static final String TABLE_NAME = "sponsors";
    @Override
    protected Sponsor mapRow(ResultSet resultSet) throws SQLException {
        Sponsor sponsor = new Sponsor();
        sponsor.setSponsorId(resultSet.getInt(SPONSOR_ID));
        sponsor.setName(resultSet.getString(NAME));
        sponsor.setSponsorshipAmount(resultSet.getDouble(SPONSORSHIP_AMOUNT));
        return sponsor;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected String getIdColumnName() {
        return SPONSOR_ID;
    }

    @Override
    protected int getId(Sponsor entity) {
        return entity.getSponsorId();
    }

    @Override
    protected String getInsertValues(Sponsor entity) {
        return "(" + NAME + ", " + SPONSORSHIP_AMOUNT  + ") VALUES ('" +
                entity.getName() + "', '" + entity.getSponsorshipAmount() + "');";
    }

    @Override
    protected String getUpdateValues(Sponsor entity) {
        return "sponsor_id='" + entity.getSponsorId() + "', name='" + entity.getName() +
                "', sponsorship_amount='" + entity.getSponsorshipAmount() + "'";
    }
}
