package Controller;
import Model.Operations;
import Model.Polynomial;
import View.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

public class Controller implements ActionListener {
    private Calculator view;
    private Operations op = new Operations();
    private Polynomial pol1 = new Polynomial();
    private Polynomial pol2 = new Polynomial();

    public Controller(Calculator v){
        this.view = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        getPolynoms();
        Polynomial result = new Polynomial();
        view.setVisibility(false);
        if(source == view.getBtnAdd()){
            result = op.addition(pol1, pol2);
        }
        else if(source == view.getBtnSubtract()) {
            result = op.subtraction(pol1, pol2);
        }
        else if(source == view.getBtnMultiply()) {
            result = op.multiplication(pol1, pol2);
        }
        else if(source == view.getBtnDivide()){
            result = division();
        }
        else if(source == view.getBtnDerivate()) {
            result =op.derivative(pol2);
            view.setTextResult2(result.convertToString());
            result = op.derivative(pol1);
        }
        else if(source == view.getBtnIntegrate()){
            result = op.integrate(pol2);
            view.setTextResult2(result.convertToString());
            result = op.integrate(pol1);
        }

        view.setTextResult(result.convertToString());
    }

    private Polynomial division(){
        Polynomial[] polyArray = new Polynomial[2];
        polyArray = op.division(pol1, pol2);
        view.setLblRemainder(polyArray[1].convertToString());
        return polyArray[0];
    }

    private void getPolynoms(){
        pol1.getPoly().clear();
        pol2.getPoly().clear();
        String polynom1Text = view.getTextPolynom1();
        String polynom2Text = view.getTextPolynom2();
        pol1.convertToPolynomial(polynom1Text);
        pol2.convertToPolynomial(polynom2Text);

    }
}
