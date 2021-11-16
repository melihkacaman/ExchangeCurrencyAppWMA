package controllers;

import views.CurrencyView;

public class CurrencyController {
    private CurrencyView currencyView;
    private String baseCurrency;
    private final static String[] popularCurrencies = new String[]{"USD", "EUR", "TRY", "JPY", "RUB"};

    public CurrencyController(String baseCurrency) {
        this.baseCurrency = baseCurrency;

    }
}
