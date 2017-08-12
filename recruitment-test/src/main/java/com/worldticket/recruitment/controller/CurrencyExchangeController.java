package com.worldticket.recruitment.controller;

import com.worldticket.recruitment.request.CurrencyExchangeRequest;
import com.worldticket.recruitment.services.CurrencyExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController extends AbstractController {

    @Autowired
    CurrencyExchangeRateService currencyExchangeRateService;

    @RequestMapping(path = "/exchange_currency", method = RequestMethod.POST, produces = "application/json")
    public Object exchangeCurrency(@RequestBody CurrencyExchangeRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return returnError(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().toString());
        }

        Object reponse = currencyExchangeRateService.calculateCurrencyRate(request);

        return reponse;
    }

}
