package controllers;

import local.CurrDefinition;
import local.CurrDefinitionProcess;
import models.Calculate;
import views.CalculateView;

import javax.swing.*;
import java.util.List;

public class CalculateController implements BaseController {
    private CalculateView calculateView;
    private Calculate calculateModel;

    public CalculateController() {

    }

    @Override
    public void initializeComponents() {
        calculateModel = new Calculate(CurrDefinitionProcess.currencies);
        calculateView = new CalculateView(calculateModel);
    }

    @Override
    public JPanel getView() {
        return calculateView;
    }
}
