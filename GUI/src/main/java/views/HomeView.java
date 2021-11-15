package views;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JPanel{
    private JTextField txt_name;
    private JButton btn_send;
    private JComboBox<String> combo_currencyList;


    public HomeView(){
        this.setLayout(new GridLayout(3, 2));
        add(new JLabel("Name: "));
        txt_name = new JTextField(20);
        add(txt_name);

        add(new JLabel("Favourite Currency:"));
        combo_currencyList = new JComboBox<>();
        combo_currencyList.addItem("asdasd"); // TODO: 11/15/2021 add currecies
        add(combo_currencyList);

        btn_send = new JButton("Go On!");
        add(new JLabel(""));
        add(btn_send);
    }
}
