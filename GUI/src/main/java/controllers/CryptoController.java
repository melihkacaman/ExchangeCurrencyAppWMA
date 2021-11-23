package controllers;

import api.ApiCrypto;
import views.CryptoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CryptoController  implements BaseController{

    private CryptoView cryptoView;

    public CryptoController() {
    }

    @Override
    public void initializeComponents() {
        cryptoView = new CryptoView();
        cryptoView.addBackButtonListener(new BackButtonListener());
        ApiCrypto.getData();
    }

    @Override
    public JPanel getView() {
        return cryptoView;
    }

    private class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
