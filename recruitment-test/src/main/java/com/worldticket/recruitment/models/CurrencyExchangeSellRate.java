package com.worldticket.recruitment.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by basssrongsil on 8/6/2017 AD.
 */
@Entity
@Table(name = "currency_exchange_sell_rate")
public class CurrencyExchangeSellRate implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    private CurrencyExchangeRate currencyExchangeRate;

    private Double fromBalance;

    private Double toBalance;

    private Double rate;

    private Date dateCreated;

    private Date lastUpdated;

    @PrePersist
    protected void onCreate() {
        dateCreated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdated = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrencyExchangeRate getCurrencyExchangeRate() {
        return currencyExchangeRate;
    }

    public void setCurrencyExchangeRate(CurrencyExchangeRate currencyExchangeRate) {
        this.currencyExchangeRate = currencyExchangeRate;
    }

    public Double getFromBalance() {
        return fromBalance;
    }

    public void setFromBalance(Double fromBalance) {
        this.fromBalance = fromBalance;
    }

    public Double getToBalance() {
        return toBalance;
    }

    public void setToBalance(Double toBalance) {
        this.toBalance = toBalance;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Map toMap() {
        Map currencyMap = new HashMap<>();
        currencyMap.put("id", this.id);
        currencyMap.put("currencyExchangeRate", this.currencyExchangeRate.getId());
        currencyMap.put("fromBalance", this.fromBalance);
        currencyMap.put("toBalance", this.toBalance);
        currencyMap.put("rate", this.rate);
        currencyMap.put("dateCreated", this.dateCreated);
        currencyMap.put("lastUpdated", this.lastUpdated);
        return currencyMap;
    }
}
