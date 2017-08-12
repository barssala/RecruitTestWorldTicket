package com.worldticket.recruitment.rowmapper;

import com.worldticket.recruitment.models.Currency;
import com.worldticket.recruitment.models.CurrencyExchangeRate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by basssrongsil on 8/12/2017 AD.
 */
public class CurrencyExchangeRateRowMapper implements RowMapper<CurrencyExchangeRate> {

    @Override
    public CurrencyExchangeRate mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CurrencyExchangeRate currencyExchangeRate = new CurrencyExchangeRate();
        currencyExchangeRate.setId(resultSet.getLong("ID"));
//        currencyExchangeRate.setSourceCurrency(resultSet.getString("SOURCE_CURRENCY"));
//        currency.setDateCreated(resultSet.getDate("DATE_CREATED"));
        currencyExchangeRate.setDateCreated(resultSet.getDate("DATE_CREATED"));
        currencyExchangeRate.setLastUpdated(resultSet.getDate("LAST_UPDATED"));
        return currencyExchangeRate;
    }
}
