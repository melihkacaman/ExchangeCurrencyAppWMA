import controllers.HomeController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame mainScreen = new JFrame();
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel content = new JPanel(new GridBagLayout());
        content.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainScreen.setContentPane(content);


        HomeController homeController = new HomeController();
        mainScreen.add(homeController.getView());

        mainScreen.pack();
        mainScreen.setLocationRelativeTo(null);
        mainScreen.setVisible(true);
    }
}
