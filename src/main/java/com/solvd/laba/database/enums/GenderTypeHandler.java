package com.solvd.laba.database.enums;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MyBatis TypeHandler for mapping the Gender enum to a database column of type ENUM.
 */
public class GenderTypeHandler implements TypeHandler<Gender> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Gender parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public Gender getResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return Gender.fromValue(value);
    }

    @Override
    public Gender getResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return Gender.fromValue(value);
    }

    @Override
    public Gender getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return Gender.fromValue(value);
    }
}