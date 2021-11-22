package views;

import local.CurrDefinition;
import models.Calculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculateView extends JPanel {
    private JTextField txt_to, txt_from;
    private JComboBox<String> combo_to, combo_from;
    private JButton btn_calculate, btn_back;
    private JLabel lbl_result;

    public CalculateView(Calculate calculate) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel pnl1 = new JPanel();
        GridLayout grd1 = new GridLayout(1,3);
        grd1.setHgap(20);
        pnl1.setLayout(grd1);
        pnl1.setLayout(grd1);

        pnl1.add(new JLabel("From:"));
        txt_from = new JTextField(20);


        combo_from = new JComboBox<>();
        combo_from.setPrototypeDisplayValue("text here is");
        combo_to = new JComboBox<>();
        combo_to.setPrototypeDisplayValue("text here is");

        for (CurrDefinition currency : calculate.getCurrDefinitionList()) {
            combo_to.addItem(currency.getCode());
            combo_from.addItem(currency.getCode());
        }
        pnl1.add(combo_from);
        pnl1.add(txt_from);
        this.add(pnl1);

        JPanel pnl2 = new JPanel();
        GridLayout grd2 = new GridLayout(1,3);
        grd2.setHgap(20);
        pnl2.setLayout(grd2);
        pnl2.add(new JLabel("To:"));
        pnl2.add(combo_to);
        txt_to = new JTextField(20);
        txt_to.setFont(txt_to.getFont().deriveFont(Font.BOLD, 14f));
        txt_to.setEnabled(false);
        pnl2.add(txt_to);
        this.add(pnl2);

        JPanel pnl3 = new JPanel();
        GridLayout grd3 = new GridLayout(1,2);
        grd3.setHgap(20);
        btn_back = new JButton("   Back   ");
        pnl3.add(btn_back);
        btn_calculate = new JButton("Calculate");
        pnl3.add(btn_calculate);
        this.add(pnl3);
    }

    public void showMessage(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public void addCalculateListener(ActionListener listener){
        btn_calculate.addActionListener(listener);
    }

    public void addBackListener(ActionListener listener){
        btn_back.addActionListener(listener);
    }

    public String getItemFromCombo_to(){
        return combo_to.getSelectedItem().toString();
    }

    public String getItemFromCombo_from(){
        return combo_from.getSelectedItem().toString();
    }

    public String getTxt_from(){
        return txt_from.getText();
    }

    public void setTxt_to(String text){
        txt_to.setText(text);
    }
}
