package View;
import Controller.Controller;
import Model.Operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    Controller controller = new Controller(this);
    public JLabel lblTitle, lblPol1, lblPol2, lblResult, lblExample, lblRemainder;
    public JTextField textPolynom1, textPolynom2, textResult, textResult2;
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

        textResult2 = new JTextField(70);
        textResult2.setBounds(120, 455, 230, 30);
        textResult2.setEditable(false);
        textResult2.setVisible(false);
        add(textResult2);
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

        lblExample = new JLabel("Example: _-_2x^3_+_4x^2_-_x_+_2 (_ - blank)");
        lblExample.setFont(new Font("Courier New", Font.PLAIN, 13));
        lblExample.setBounds(22, 185, 360, 40);
        add(lblExample);

        lblRemainder = new JLabel();
        lblRemainder.setFont(new Font("Courier New", Font.PLAIN, 13));
        lblRemainder.setBounds(30, 450, 250, 30);
        add(lblRemainder);
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

    public void setLblRemainder(String str){
        lblRemainder.setVisible(true);
        lblRemainder.setText("Remainder: " + str);
    }

    public void setVisibility(boolean hide){
        textResult2.setVisible(hide);
        lblRemainder.setVisible(hide);
    }

    public void setTextResult2(String str){
        textResult2.setVisible(true);
        textResult2.setText(str);
    }
}