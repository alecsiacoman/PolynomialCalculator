import Controller.Operations;
import View.Calculator;

import java.awt.*;

public class App {
    public static void main(String[] args){
        Calculator c = new Calculator();
        c.setBounds(700, 300, 400, 550);
        c.setTitle("Polynomial Calculator");
        c.setVisible(true);
        c.setResizable(false);
        c.getContentPane().setBackground(new Color(217, 191, 205));
    }
}
