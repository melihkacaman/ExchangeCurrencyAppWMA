package controllers;

import api.ApiCrypto;
import api.ApiCurrencyConnect;
import app.App;
import common.ActiveUser;
import org.json.simple.parser.ParseException;
import views.CurrencyView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class CurrencyController implements BaseController {
    private CurrencyView currencyView;
    private String baseCurrency;
    private final static String[] popularCurrencies = new String[]{"USD", "EUR", "TRY", "JPY", "RUB"};

    public CurrencyController(){

    }

    @Override
    public JPanel getView() {
        return currencyView;
    }

    @Override
    public void initializeComponents() {
        baseCurrency = ActiveUser.activeUser.getPopularCurrency().getCode();
        currencyView = new CurrencyView();
        getCurrencies();
        currencyView.addListenerToRefreshButton(new RefreshListener());
        currencyView.addListenerToCalculateButton(new CalculateListener());
        currencyView.addListenerToCryptoButton(new CryptoListener());
    }

    private void getCurrencies(){
        new Thread(() -> {
            try {
                List<String> getBunchOfCurrencies = ApiCurrencyConnect.
                        getBunchOfCurrencies(baseCurrency,popularCurrencies);
                if (!getBunchOfCurrencies.isEmpty())
                    CurrencyController.this.currencyView.populateList(getBunchOfCurrencies);
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getCurrencies();
            CurrencyController.this.currencyView.showMessage("Update", "Successfully updated.");
        }
    }


    private class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            App.pushScreen(new CalculateController());
            App.nextScreen(CurrencyController.this.currencyView);
        }
    }

    private class CryptoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            App.pushScreen(new CryptoController());
            App.nextScreen(CurrencyController.this.currencyView);
        }
    }
}
