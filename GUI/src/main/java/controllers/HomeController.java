package controllers;

import app.App;
import common.ActiveUser;
import common.User;
import local.CurrDefinition;
import local.CurrDefinitionProcess;
import models.Home;
import views.HomeView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HomeController implements BaseController {
    private HomeView homeView;
    private List<CurrDefinition> currDefinitionList;
    private Home homeModel;

    @Override
    public JPanel getView() {
        return homeView;
    }

    @Override
    public void initializeComponents() {
        currDefinitionList = CurrDefinitionProcess.currencies;
        homeModel = new Home(currDefinitionList);
        homeView = new HomeView(homeModel);

        homeView.addActionListener(new GoOnListener());
    }


    private class GoOnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = homeView.getName();
            String favouriteCurrency = homeView.getSelectedCurrency();

            CurrDefinition currencyDefinition = CurrDefinitionProcess.getCurrencyFromSelectedItem(favouriteCurrency);

            User user = new User(name, currencyDefinition);
            ActiveUser.activeUser = user;

           // App.removeView(HomeController.this.homeView);
           App.nextScreen(HomeController.this.homeView);
        }
    }
}
