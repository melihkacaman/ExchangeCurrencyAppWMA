package views;

import common.ActiveUser;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
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

        JPanel pnl3 = new JPanel(new GridLayout(3,1));

        btn_refresh = new JButton("Refresh the list");
        pnl3.add(btn_refresh);

        btn_calculate = new JButton("Calculate the currency");
        pnl3.add(btn_calculate);

        btn_allList = new JButton("Crypto!");
        pnl3.add(btn_allList);

        this.add(pnl3);
    }

    public synchronized void populateList(List<String> items){
        listModel.clear();
        for (String item : items) {
            listModel.addElement(item);
        }
        lst_currencies.repaint();
    }

    public void addListenerToRefreshButton(ActionListener listener){
        btn_refresh.addActionListener(listener);
    }

    public void addListenerToCalculateButton(ActionListener listener){
        btn_calculate.addActionListener(listener);
    }

    public void addListenerToAllListButton(ActionListener listener){
        btn_allList.addActionListener(listener);
    }

    public void showMessage(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
