package views;

import local.CurrDefinition;
import models.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomeView extends JPanel{
    private JTextField txt_name;
    private JButton btn_send;
    private JComboBox<String> combo_currencyList;
    private Home model;

    public HomeView(Home model){
        this.model = model;
        this.setLayout(new GridLayout(3, 2));
        add(new JLabel("Name: "));
        txt_name = new JTextField(20);
        add(txt_name);

        add(new JLabel("Favourite Currency:"));
        combo_currencyList = new JComboBox<>();
        // populate comboBox
        for (CurrDefinition curr: this.model.getCurrencies()) {
            combo_currencyList.addItem(curr.getCode() + "-" + curr.getName());
        }
        add(combo_currencyList);

        btn_send = new JButton("Go On!");
        add(new JLabel(""));
        add(btn_send);
    }

    public String getName(){
        return txt_name.getText();
    }

    public String getSelectedCurrency(){
        return combo_currencyList.getSelectedItem().toString();
    }

    public void addActionListener(ActionListener listener){
        btn_send.addActionListener(listener);
    }
}
