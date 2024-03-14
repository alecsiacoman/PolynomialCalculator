package View;
import Controller.Controller;
import Model.Operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    Controller controller = new Controller(this);
    public JLabel lblTitle, lblPol1, lblPol2, lblResult, lblExample;
    public JTextField textPolynom1, textPolynom2, textResult;
    public JButton btnAdd, btnSubtract, btnDivide, btnMultiply, btnIntegrate, btnDerivate;

    public Calculator() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        //title of calculator
        lblTitle = new JLabel("CALCULATOR");
        lblTitle.setFont(new Font("Courier New", Font.BOLD, 35));
        lblTitle.setBounds(80, 20, 300, 30);
        add(lblTitle);

        addTextFields();
        addLabels();
        addButtons();
        setActions();

        //        textPolynom1.setText("x^3 - 2x^2 + 6x - 5");
        //        textPolynom2.setText("x^2 - 1");
    }

    private void addTextFields() {
        textPolynom1 = new JTextField(70);
        textPolynom2 = new JTextField(70);
        textPolynom1.setBounds(180, 100, 170, 30);
        textPolynom2.setBounds(180, 140, 170, 30);
        add(textPolynom1);
        add(textPolynom2);

        textResult = new JTextField(70);
        textResult.setBounds(120, 420, 230, 30);
        textResult.setEditable(false);
        add(textResult);
    }

    private void addLabels(){
        lblPol1 = new JLabel("Polynom 1: ");
        lblPol2 = new JLabel("Polynom 2: ");
        setPropertiesLabels(lblPol1);
        setPropertiesLabels(lblPol2);
        lblPol1.setBounds(30, 100, 150, 30);
        lblPol2.setBounds(30, 140, 150, 30);
        add(lblPol1);
        add(lblPol2);

        lblResult = new JLabel("Result: ");
        setPropertiesLabels(lblResult);
        lblResult.setBounds(30, 420, 150, 30);
        add(lblResult);

        lblExample = new JLabel("Polynomial Example: 2x^3 - 6x^2 + x + 9");
        lblExample.setFont(new Font("Courier New", Font.PLAIN, 15));
        lblExample.setBounds(18, 185, 360, 40);
        add(lblExample);
    }

    private void addButtons() {
        //creating the button
        btnAdd = new JButton("Add");
        btnSubtract = new JButton("Subtract");
        btnMultiply = new JButton("Multiply");
        btnDivide = new JButton("Divide");
        btnIntegrate = new JButton("Integrate");
        btnDerivate = new JButton("Derivate");

        //properties
        btnAdd.setBounds(70, 250, 120, 30);
        btnSubtract.setBounds(200, 250, 120, 30);
        btnMultiply.setBounds(70, 290, 120, 30);
        btnDivide.setBounds(200, 290, 120, 30);
        btnIntegrate.setBounds(70, 330, 120, 30);
        btnDerivate.setBounds(200, 330, 120, 30);

        setPropertiesButton(btnAdd);
        setPropertiesButton(btnSubtract);
        setPropertiesButton(btnMultiply);
        setPropertiesButton(btnDivide);
        setPropertiesButton(btnIntegrate);
        setPropertiesButton(btnDerivate);

        //adding the button to the window
        add(btnAdd);
        add(btnSubtract);
        add(btnMultiply);
        add(btnDivide);
        add(btnIntegrate);
        add(btnDerivate);
    }

    private void setPropertiesButton(JButton btn){
        btn.setFont(new Font("Courier New", Font.BOLD, 15));
    }

    private void setPropertiesLabels(JLabel lbl){
        lbl.setFont(new Font("Courier New", Font.ITALIC, 20));
    }

    private void setActions(){
        btnAdd.addActionListener(controller);
        btnSubtract.addActionListener(controller);
        btnMultiply.addActionListener(controller);
        btnDivide.addActionListener(controller);
        btnDerivate.addActionListener(controller);
        btnIntegrate.addActionListener(controller);
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton  getBtnSubtract(){
        return btnSubtract;
    }

    public JButton getBtnMultiply() {
        return btnMultiply;
    }

    public JButton getBtnDivide() {
        return btnDivide;
    }

    public JButton getBtnDerivate() {
        return btnDerivate;
    }

    public JButton getBtnIntegrate() {
        return btnIntegrate;
    }

    public String getTextPolynom1() {
        return textPolynom1.getText();
    }

    public String getTextPolynom2() {
        return textPolynom2.getText();
    }

    public void setTextResult(String str){ textResult.setText(str); };


}