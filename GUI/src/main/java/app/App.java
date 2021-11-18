package app;

import controllers.BaseController;
import controllers.CurrencyController;
import controllers.HomeController;
import local.CurrDefinition;
import local.CurrDefinitionProcess;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class App {
    private static JFrame mainScreen;
    private static Stack<BaseController> screens;
    static {
        mainScreen = new JFrame();
        screens = new Stack<>();
    }

    public static void main(String[] args) throws IOException, ParseException {

        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel content = new JPanel(new GridBagLayout());
        content.setBorder(new EmptyBorder(50, 50, 50, 50));
        mainScreen.setContentPane(content);

        // add homeController
        HomeController homeController = new HomeController();
        screens.push(homeController);
        nextScreen(null); // for the first invocation

        // add currencyController
        CurrencyController currencyController = new CurrencyController();
        screens.push(currencyController);

        mainScreen.pack();
        mainScreen.setLocationRelativeTo(null);
        mainScreen.setVisible(true);
    }

    public static void removeView(JPanel view){
        mainScreen.remove(view);
        mainScreen.repaint();
    }

    public static void nextScreen(JPanel itself){
        if (itself != null){
            mainScreen.remove(itself);
            mainScreen.repaint();
        }

        BaseController controller = screens.pop();
        controller.initializeComponents();
        mainScreen.add(controller.getView());
        mainScreen.repaint();
    }
}
