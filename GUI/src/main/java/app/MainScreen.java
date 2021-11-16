package app;

import controllers.HomeController;
import local.CurrDefinition;
import local.CurrDefinitionProcess;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MainScreen {
    private static JFrame mainScreen;

    static {
        mainScreen = new JFrame();
    }

    public static void main(String[] args) {

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

    public static void removeView(JPanel view){
        mainScreen.remove(view);
        mainScreen.repaint();
    }
}
