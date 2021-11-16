package controllers;

import app.MainScreen;
import common.ActiveUser;
import common.User;
import local.CurrDefinition;
import local.CurrDefinitionProcess;
import models.HomeModel;
import views.HomeView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HomeController {
    private HomeView homeView;
    private List<CurrDefinition> currDefinitionList;
    private HomeModel homeModel;

    public HomeController() {
        currDefinitionList = CurrDefinitionProcess.currencies;
        homeModel = new HomeModel(currDefinitionList);
        homeView = new HomeView(homeModel);

        homeView.addActionListener(new GoOnListener());
    }

    public JPanel getView() {
        return homeView;
    }


    private class GoOnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = homeView.getName();
            String favouriteCurrency = homeView.getSelectedCurrency();

            CurrDefinition currencyDefinition = CurrDefinitionProcess.getCurrencyFromSelectedItem(favouriteCurrency);

            User user = new User(name, currencyDefinition);
            ActiveUser.activeUser = user;

           MainScreen.removeView(HomeController.this.homeView);
        }
    }
}
