package com.worldticket.recruitment.rowmapper;

import com.worldticket.recruitment.models.CurrencyExchangeRate;
import com.worldticket.recruitment.models.CurrencyExchangeSellRate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by basssrongsil on 8/12/2017 AD.
 */
public class CurrencyExchangeSellRateRowMapper implements RowMapper<CurrencyExchangeSellRate> {

    @Override
    public CurrencyExchangeSellRate mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CurrencyExchangeSellRate currencyExchangeSellRate = new CurrencyExchangeSellRate();
        currencyExchangeSellRate.setId(resultSet.getLong("ID"));
        currencyExchangeSellRate.setFromBalance(resultSet.getDouble("FROM_BALANCE"));
        currencyExchangeSellRate.setToBalance(resultSet.getDouble("TO_BALANCE"));
        currencyExchangeSellRate.setRate(resultSet.getDouble("RATE"));
        currencyExchangeSellRate.setDateCreated(resultSet.getDate("DATE_CREATED"));
        currencyExchangeSellRate.setLastUpdated(resultSet.getDate("LAST_UPDATED"));
        return currencyExchangeSellRate;
    }
}
