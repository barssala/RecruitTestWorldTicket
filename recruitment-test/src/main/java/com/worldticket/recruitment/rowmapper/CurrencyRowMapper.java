package com.worldticket.recruitment.rowmapper;

import com.worldticket.recruitment.models.Currency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by basssrongsil on 8/12/2017 AD.
 */
public class CurrencyRowMapper implements RowMapper<Currency> {

    @Override
    public Currency mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Currency currency = new Currency();
        currency.setId(resultSet.getLong("ID"));
        currency.setCurrencyCode(resultSet.getString("CURRENCY_CODE"));
        currency.setDateCreated(resultSet.getDate("DATE_CREATED"));
        currency.setLastUpdated(resultSet.getDate("LAST_UPDATED"));
        return currency;
    }
}
