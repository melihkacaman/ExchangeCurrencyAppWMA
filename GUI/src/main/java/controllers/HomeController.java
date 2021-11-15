package controllers;

import views.HomeView;

import javax.swing.*;

public class HomeController {
    private HomeView homeView;

    public HomeController() {
        homeView = new HomeView();
    }

    public JPanel getView() {
        return homeView;
    }
}
