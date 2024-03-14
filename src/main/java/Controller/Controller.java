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

        if(source == view.getBtnAdd()){
            result.setPoly(op.addition(pol1, pol2));
        }
        else if(source == view.getBtnSubtract()) {
            result.setPoly(op.subtraction(pol1, pol2));
        }
        else if(source == view.getBtnMultiply()) {
            result.setPoly(op.multiplication(pol1, pol2));
        }
        else if(source == view.getBtnDivide())
            result.setPoly(op.division(pol1, pol2));
        else if(source == view.getBtnDerivate()) {
            result.setPoly(op.derivative(pol1));
        }
        else if(source == view.getBtnIntegrate()){
            result.setPoly(op.integrate(pol1));
        }

        view.setTextResult(result.convertToString());
    }

    private void getPolynoms(){
        pol1.clearTreeMap();
        pol2.clearTreeMap();
        String polynom1Text = view.getTextPolynom1();
        String polynom2Text = view.getTextPolynom2();
        pol1.convertToPolynomial(polynom1Text);
        pol2.convertToPolynomial(polynom2Text);

    }
}
