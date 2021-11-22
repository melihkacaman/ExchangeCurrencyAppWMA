package controllers;

import api.ApiConnect;
import app.App;
import local.CurrDefinition;
import local.CurrDefinitionProcess;
import models.Calculate;
import models.Currency;
import org.json.simple.parser.ParseException;
import views.CalculateView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

        calculateView.addCalculateListener(new CalculateListener());
        calculateView.addBackListener(new BackListener());
    }

    @Override
    public JPanel getView() {
        return calculateView;
    }

    private class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!calculateView.getTxt_from().isEmpty() && !calculateView.getTxt_from().isBlank()) {
                double fromValue = Double.parseDouble(calculateView.getTxt_from());
                String fromCode = calculateView.getItemFromCombo_from();
                String toCode = calculateView.getItemFromCombo_to();
                if (fromCode.equals(toCode)){
                    calculateView.showMessage(fromCode + "to " + toCode,"Warning");
                }else{
                    Currency res = null;
                    try {
                        res = ApiConnect.makeRequest(fromCode, toCode);
                    } catch (IOException | ParseException ee) {
                        ee.printStackTrace();
                    }

                    if (res != null){
                        double currResult = res.getCurr() * fromValue;
                        calculateView.setTxt_to(""+currResult);
                    }else {
                        CalculateController.this.calculateView.showMessage( "Please, check your internet connection.","Error");
                    }
                }
            }else {
                calculateView.showMessage("Check your values", "Error");
            }
        }
    }

    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            App.pushScreen(new CurrencyController());
            App.nextScreen(CalculateController.this.calculateView);
        }
    }
}
