package com.worldticket.recruitment.repository;

import com.worldticket.recruitment.models.CurrencyExchangeRate;
import com.worldticket.recruitment.models.CurrencyExchangeSellRate;
import com.worldticket.recruitment.rowmapper.CurrencyExchangeSellRateRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by basssrongsil on 8/12/2017 AD.
 */
@Repository
public class CurrencyExchangeSellRateRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<CurrencyExchangeSellRate> findByCurrencyExchangeRate(CurrencyExchangeRate currencyExchangeRate) {
        return jdbcTemplate.query(
                "SELECT * from \"currency_exchange_sell_rate\" WHERE \"CURRENCY_EXCHANGE_RATE\" = ?;",
                new Object[] { currencyExchangeRate.getId(),},
                new CurrencyExchangeSellRateRowMapper());
    }
}
