package com.worldticket.recruitment.repository;

import com.worldticket.recruitment.models.Currency;
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
public class CurrencyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<Currency> findAll() {
        return jdbcTemplate.query("SELECT * from \"currency\";", new CurrencyRowMapper());
    }

    @Transactional(readOnly = true)
    public Currency findByCurrencyCode(String currencyCode) {
        List<Currency> results =  jdbcTemplate.query(
                "SELECT * from \"currency\" WHERE \"CURRENCY_CODE\" = ?;",
                new Object[] { currencyCode },
                new CurrencyRowMapper());

        return results.isEmpty() ? null : results.get(0);
    }
}
