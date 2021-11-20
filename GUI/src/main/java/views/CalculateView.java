package views;

import local.CurrDefinition;
import models.Calculate;

import javax.swing.*;
import java.awt.*;

public class CalculateView extends JPanel {
    private JTextField txt_to, txt_from;
    private JComboBox<String> combo_to, combo_from;
    private JButton btn_calculate, btn_back;
    private JLabel lbl_result;

    public CalculateView(Calculate calculate) {
        this.setLayout(new GridLayout(5,3));

        this.add(new JLabel("From:"));
        txt_from = new JTextField(20);
        this.add(txt_from);

        combo_from = new JComboBox<>();
        combo_to = new JComboBox<>();
        for (CurrDefinition currency : calculate.getCurrDefinitionList()) {
            combo_to.addItem(currency.getCode());
            combo_from.addItem(currency.getCode());
        }
        this.add(combo_from);

        this.add(new JLabel("To:"));
        txt_to = new JTextField(20);
        this.add(txt_to);
        this.add(combo_to);


        btn_back = new JButton("Back");
        this.add(btn_back);
        btn_calculate = new JButton("Calculate");
        this.add(btn_calculate);
    }
}
