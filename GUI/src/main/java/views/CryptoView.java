package views;

import common.Crypto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CryptoView extends JPanel {
    private JList<String> lst_cryptos;
    private DefaultListModel<String> listModel;
    private JButton backButton;

    public CryptoView() {
        this.setLayout(new FlowLayout());
        listModel = new DefaultListModel<>();
        lst_cryptos = new JList<>(listModel);
        JScrollPane table_sp=new JScrollPane(lst_cryptos);
        table_sp.setSize(new Dimension(600,600));
        this.add(table_sp);

        this.backButton = new JButton("Back");
        this.add(backButton);
    }

    public void addBackButtonListener(ActionListener listener){
        backButton.addActionListener(listener);
    }

    public void populateList(List<String> items){
        listModel.clear();
        for (String item : items) {
            listModel.addElement(item);
        }
        lst_cryptos.repaint();
    }
}
