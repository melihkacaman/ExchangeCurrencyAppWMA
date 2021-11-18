package views;

import common.ActiveUser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class CurrencyView extends JPanel {
    private JButton btn_refresh;
    private JButton btn_calculate;
    private JList<String> lst_currencies;
    private DefaultListModel<String> listModel;
    private JButton btn_allList;

    public CurrencyView() {
        this.setLayout(new FlowLayout());

        JPanel pnl1 = new JPanel(new GridLayout(2,1));
        pnl1.add(new JLabel("Hello, "+ ActiveUser.activeUser.getName() + "!"));
        pnl1.add(new JLabel("Your currency is "+ ActiveUser.activeUser.getPopularCurrency().getCode() + ".   "));
        this.add(pnl1);

        JPanel pnl2 = new JPanel();
        pnl2.setLayout(new BoxLayout(pnl2, BoxLayout.Y_AXIS));

        JLabel lbl = new JLabel("Currencies: ");
        pnl2.add(lbl);

        listModel = new DefaultListModel<>();
        // populate with popular currencies as a response of thread.
        lst_currencies = new JList<>(listModel);
        lst_currencies.setBorder(new EmptyBorder(0,20,0,20));
        pnl2.add(lst_currencies);
        this.add(pnl2);

        btn_refresh = new JButton("Refresh the list");
        this.add(btn_refresh);

        btn_calculate = new JButton("Calculate the currency");
        this.add(btn_calculate);
    }

    public synchronized void populateList(List<String> items){
        for (String item : items) {
            listModel.addElement(item);
        }
        lst_currencies.repaint();
    }

    public void addListenerToRefreshButton(){

    }

    public void addListenerToCalculateButton(){

    }

    public void addListenerToAllListButton(){

    }
}
