package com.worldticket.recruitment.repository;

import com.worldticket.recruitment.models.Currency;
import com.worldticket.recruitment.models.CurrencyExchangeRate;
import com.worldticket.recruitment.rowmapper.CurrencyExchangeRateRowMapper;
import com.worldticket.recruitment.rowmapper.CurrencyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by basssrongsil on 8/12/2017 AD.
 */
@Repository
public class CurrencyExchangeRateRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public CurrencyExchangeRate findBySourceCurrencyAndTargetCurrency(Currency sourceCurrency, Currency targetCurrency) {
        List<CurrencyExchangeRate> results = jdbcTemplate.query(
                "SELECT * from \"currency_exchange_rate\" WHERE \"SOURCE_CURRENCY\" = ? AND \"TARGET_CURRENCY\" = ?;",
                new Object[] { sourceCurrency.getId(), targetCurrency.getId(),},
                new CurrencyExchangeRateRowMapper());

        return results.isEmpty() ? null : results.get(0);
    }
}
