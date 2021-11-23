package controllers;

import api.ApiCrypto;
import app.App;
import common.Crypto;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import views.CryptoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CryptoController  implements BaseController{

    private CryptoView cryptoView;
    private List<String> items;

    public CryptoController() {
    }

    @Override
    public void initializeComponents() {
        items = new ArrayList<>();
        cryptoView = new CryptoView();
        cryptoView.addBackButtonListener(new BackButtonListener());

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(ApiCrypto.getObservableForCrypto()
                .subscribeOn(Schedulers.trampoline())
                .observeOn(Schedulers.trampoline())
                .subscribe(this::handleResponse));

    }

    private void handleResponse(List<Crypto> model){
        if (model != null && !model.isEmpty()){
            int i = 0;
            for (Crypto crypto:model) {
                items.add(crypto.currency +" : " +crypto.price + "$");
            }
        }

        cryptoView.populateList(items);
    }


    @Override
    public JPanel getView() {
        return cryptoView;
    }

    private class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            App.pushScreen(new CurrencyController());
            App.nextScreen(CryptoController.this.cryptoView);
        }
    }
}
