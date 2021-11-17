package controllers;

import api.ApiConnect;
import org.json.simple.parser.ParseException;
import views.CurrencyView;

import java.io.IOException;
import java.util.List;

public class CurrencyController {
    private CurrencyView currencyView;
    private String baseCurrency;
    private final static String[] popularCurrencies = new String[]{"USD", "EUR", "TRY", "JPY", "RUB"};

    public CurrencyController(String baseCurrency) throws IOException, ParseException {
        this.baseCurrency = baseCurrency;
       // List<String> getBunchOfCurrencies = ApiConnect.getBunchOfCurrencies(baseCurrency,popularCurrencies);
        System.out.println("deneme");
    }
}
