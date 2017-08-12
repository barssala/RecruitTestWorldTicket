package com.worldticket.recruitment.request;

import com.worldticket.recruitment.constant.RecruitTestConstant;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by basssrongsil on 8/6/2017 AD.
 */
public class CurrencyExchangeRequest implements Serializable {

    @NotNull
    private Double balance;

    @NotNull
    private String sourceCurrency;

    @NotNull
    private String targetCurrency;

    @NotNull
    private RecruitTestConstant.Action action;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public String getAction() {
        return action.toString();
    }

    public Map toMap() {
        Map currencyMap = new HashMap<>();
        currencyMap.put("balance", this.balance);
        currencyMap.put("sourceCurrency", this.sourceCurrency);
        currencyMap.put("targetCurrency", this.targetCurrency);
        currencyMap.put("action", this.action);
        return currencyMap;
    }
}

