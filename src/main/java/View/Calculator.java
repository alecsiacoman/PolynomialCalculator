package View;
import Controller.Controller;
import Model.Operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {

    Controller controller = new Controller(this);
    public JLabel title, pol1, pol2, result;
    public JTextField textPolynom1, textPolynom2, textResult;
    public JButton addBtn, subtractBtn, divideBtn, multiplyBtn, integrateBtn, derivBtn;

    public Calculator() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        //title of the calculator
        title = new JLabel("CALCULATOR");
        title.setFont(new Font("Courier New", Font.BOLD, 35));
        title.setBounds(80, 20, 300, 30);
        add(title);
        addTextFields();
        addButtons();
        setActions();
    }

    private void addTextFields() {
        textPolynom1 = new JTextField(70);
        textPolynom2 = new JTextField(70);
        textPolynom1.setBounds(180, 100, 170, 30);
        textPolynom2.setBounds(180, 140, 170, 30);
        add(textPolynom1);
        add(textPolynom2);

        pol1 = new JLabel("Polynom 1: ");
        pol2 = new JLabel("Polynom 2: ");
        pol1.setFont(new Font("Courier New", Font.ITALIC, 20));
        pol2.setFont(new Font("Courier New", Font.ITALIC, 20));
        pol1.setBounds(30, 100, 150, 30);
        pol2.setBounds(30, 140, 150, 30);
        add(pol1);
        add(pol2);

        result = new JLabel("Result: ");
        result.setFont(new Font("Courier New", Font.ITALIC, 20));
        result.setBounds(50, 430, 150, 30);
        textResult = new JTextField(70);
        textResult.setBounds(160, 430, 170, 30);
        textResult.setEditable(false);
        add(result);
        add(textResult);
    }

    private void addButtons() {
        //creating the button
        addBtn = new JButton("Add");
        subtractBtn = new JButton("Subtract");
        multiplyBtn = new JButton("Multiply");
        divideBtn = new JButton("Divide");
        integrateBtn = new JButton("Integrate");
        derivBtn = new JButton("Derivate");

        //properties
        addBtn.setBounds(70, 250, 120, 30);
        subtractBtn.setBounds(200, 250, 120, 30);
        multiplyBtn.setBounds(70, 290, 120, 30);
        divideBtn.setBounds(200, 290, 120, 30);
        integrateBtn.setBounds(70, 330, 120, 30);
        derivBtn.setBounds(200, 330, 120, 30);

        setProperties(addBtn);
        setProperties(subtractBtn);
        setProperties(multiplyBtn);
        setProperties(divideBtn);
        setProperties(integrateBtn);
        setProperties(derivBtn);

        //adding the button to the window
        add(addBtn);
        add(subtractBtn);
        add(multiplyBtn);
        add(divideBtn);
        add(integrateBtn);
        add(derivBtn);
    }

    private void setProperties(JButton btn){
        btn.setFont(new Font("Courier New", Font.BOLD, 15));
    }

    private void setActions(){
        addBtn.addActionListener(controller);
        subtractBtn.addActionListener(controller);
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton  getSubtractBtn(){
        return subtractBtn;
    }

    public JTextField getTextPolynom1() {
        return textPolynom1;
    }

    public JTextField getTextPolynom2() {
        return textPolynom2;
    }

    public JTextField getTextResult() {
        return textResult;
    }
}