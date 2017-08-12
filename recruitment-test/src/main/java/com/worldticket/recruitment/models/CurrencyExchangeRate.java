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
@Table(name = "currency_exchange_rate")
public class CurrencyExchangeRate implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @OneToOne
    private Currency sourceCurrency;

    @NotNull
    @OneToOne
    private Currency targetCurrency;

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

    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(Currency sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(Currency targetCurrency) {
        this.targetCurrency = targetCurrency;
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
        currencyMap.put("sourceCurrency", this.sourceCurrency.getCurrencyCode());
        currencyMap.put("targetCurrency", this.targetCurrency.getCurrencyCode());
        currencyMap.put("dateCreated", this.dateCreated);
        currencyMap.put("lastUpdated", this.lastUpdated);
        return currencyMap;
    }
}
