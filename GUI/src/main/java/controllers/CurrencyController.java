package controllers;

import api.ApiConnect;
import common.ActiveUser;
import org.json.simple.parser.ParseException;
import views.CurrencyView;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class CurrencyController implements BaseController {
    private CurrencyView currencyView;
    private String baseCurrency;
    private final static String[] popularCurrencies = new String[]{"USD", "EUR", "TRY", "JPY", "RUB"};

    public CurrencyController() throws IOException, ParseException {

    }

    @Override
    public JPanel getView() {
        return currencyView;
    }

    @Override
    public void initializeComponents() {
        baseCurrency = ActiveUser.activeUser.getPopularCurrency().getCode();
        currencyView = new CurrencyView();
        new Thread(() -> {
            try {
                List<String> getBunchOfCurrencies = ApiConnect.
                        getBunchOfCurrencies(baseCurrency,popularCurrencies);
                if (!getBunchOfCurrencies.isEmpty())
                    CurrencyController.this.currencyView.populateList(getBunchOfCurrencies);
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
