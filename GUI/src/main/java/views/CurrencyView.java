package views;

import common.ActiveUser;

import javax.swing.*;
import java.awt.*;

public class CurrencyView extends JPanel {
    private JButton btn_refresh;
    private JButton btn_calculate;
    private JList<String> lst_currencies;

    public CurrencyView() {
        this.setLayout(new GridLayout(4,1));

        this.add(new JLabel("Hello, "+ ActiveUser.activeUser.getName() + "!"));
        this.add(new JLabel("Currencies: "));

        DefaultListModel<String> listModel = new DefaultListModel<>();
        // populate with popular currencies
        lst_currencies = new JList<>(listModel);
        this.add(lst_currencies);

        btn_refresh = new JButton("Refresh the list");
        this.add(btn_refresh);

        btn_calculate = new JButton("Calculate the currency");
        this.add(btn_calculate);
    }


}
