package com.worldticket.recruitment.services;

import com.worldticket.recruitment.constant.RecruitTestConstant;
import com.worldticket.recruitment.models.Currency;
import com.worldticket.recruitment.models.CurrencyExchangeBuyRate;
import com.worldticket.recruitment.models.CurrencyExchangeRate;
import com.worldticket.recruitment.models.CurrencyExchangeSellRate;
import com.worldticket.recruitment.repository.CurrencyExchangeBuyRateRepository;
import com.worldticket.recruitment.repository.CurrencyExchangeRateRepository;
import com.worldticket.recruitment.repository.CurrencyExchangeSellRateRepository;
import com.worldticket.recruitment.repository.CurrencyRepository;
import com.worldticket.recruitment.request.CurrencyExchangeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by basssrongsil on 8/6/2017 AD.
 */
@Service
public class CurrencyExchangeRateService implements Serializable {

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    CurrencyExchangeRateRepository currencyExchangeRateRepository;

    @Autowired
    CurrencyExchangeSellRateRepository currencyExchangeSellRateRepository;

    @Autowired
    CurrencyExchangeBuyRateRepository currencyExchangeBuyRateRepository;

    public Object calculateCurrencyRate(CurrencyExchangeRequest request) {

        Currency sourceCurrency = currencyRepository.findByCurrencyCode(request.getSourceCurrency());
        Currency targetCurrency = currencyRepository.findByCurrencyCode(request.getTargetCurrency());

        CurrencyExchangeRate currencyExchangeRate = currencyExchangeRateRepository.findBySourceCurrencyAndTargetCurrency(sourceCurrency, targetCurrency);

        Double rate = 0D;
        if (request.getAction().equals(RecruitTestConstant.Action.BUY.toString())) {

            List<CurrencyExchangeBuyRate> currencyExchangeBuyRates = currencyExchangeBuyRateRepository.findByCurrencyExchangeRate(currencyExchangeRate);
            rate = getBuyingExchangeRateCurrency(currencyExchangeBuyRates, request.getBalance());

        } else if (request.getAction().equals(RecruitTestConstant.Action.SELL.toString())) {

            List<CurrencyExchangeSellRate> currencyExchangeSellRates = currencyExchangeSellRateRepository.findByCurrencyExchangeRate(currencyExchangeRate);
            rate = getSellingExchangeRateCurrency(currencyExchangeSellRates, request.getBalance());

        }

        Map response = new HashMap<>();
        response.put("resultExchange", (request.getBalance() * rate));
        response.put("rate", rate);

        return response;
    }

    private Double getBuyingExchangeRateCurrency(List<CurrencyExchangeBuyRate> currencyExchangeBuyRates, Double balance) {
        for (CurrencyExchangeBuyRate currencyExchangeBuyRate : currencyExchangeBuyRates) {
            Double fromBalance = currencyExchangeBuyRate.getFromBalance();
            Double toBalance = currencyExchangeBuyRate.getToBalance();
            if (fromBalance <= balance && balance <= toBalance) {
                return currencyExchangeBuyRate.getRate();
            }
        }

        return -1d;
    }

    private Double getSellingExchangeRateCurrency(List<CurrencyExchangeSellRate> currencyExchangeSellRates, Double balance) {
        for (CurrencyExchangeSellRate currencyExchangeSellRate: currencyExchangeSellRates) {
            Double fromBalance = currencyExchangeSellRate.getFromBalance();
            Double toBalance = currencyExchangeSellRate.getToBalance();
            if (fromBalance <= balance && balance <= toBalance) {
                return currencyExchangeSellRate.getRate();
            }
        }
        return -1d;
    }
}
