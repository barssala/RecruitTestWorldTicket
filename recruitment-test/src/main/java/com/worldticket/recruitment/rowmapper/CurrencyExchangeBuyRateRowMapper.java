package com.worldticket.recruitment.rowmapper;

import com.worldticket.recruitment.models.CurrencyExchangeBuyRate;
import com.worldticket.recruitment.models.CurrencyExchangeSellRate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by basssrongsil on 8/12/2017 AD.
 */
public class CurrencyExchangeBuyRateRowMapper implements RowMapper<CurrencyExchangeBuyRate> {

    @Override
    public CurrencyExchangeBuyRate mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CurrencyExchangeBuyRate currencyExchangeBuyRate = new CurrencyExchangeBuyRate();
        currencyExchangeBuyRate.setId(resultSet.getLong("ID"));
        currencyExchangeBuyRate.setFromBalance(resultSet.getDouble("FROM_BALANCE"));
        currencyExchangeBuyRate.setToBalance(resultSet.getDouble("TO_BALANCE"));
        currencyExchangeBuyRate.setRate(resultSet.getDouble("RATE"));
        currencyExchangeBuyRate.setDateCreated(resultSet.getDate("DATE_CREATED"));
        currencyExchangeBuyRate.setLastUpdated(resultSet.getDate("LAST_UPDATED"));
        return currencyExchangeBuyRate;
    }
}
