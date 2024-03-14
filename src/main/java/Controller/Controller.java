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

    private void getPolynoms(){
        String polynom1Text = view.getTextPolynom1();
        String polynom2Text = view.getTextPolynom2();
        pol1.convertToPolynomial(polynom1Text);
        pol2.convertToPolynomial(polynom2Text);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        getPolynoms();
        //System.out.println(pol1.convertToString() + " and " + pol2.convertToString());
        Polynomial result = new Polynomial();
        if(source == view.getAddBtn()){
            result.setPoly(op.additionOrSubtraction(pol1, pol2, 0));
        }
        else if(source == view.getSubtractBtn()) {
            result.setPoly(op.additionOrSubtraction(pol1, pol2, 1));
        }
        else if(source == view.getMultiplyBtn()) {
            result.setPoly(op.multiplication(pol1, pol2));
        }
        else if(source == view.getDivideBtn())
            result.setPoly(op.division(pol1, pol2));
        else if(source == view.getDerivBtn()) {
            result.setPoly(op.derivative(pol1));
        }
        else if(source == view.getIntegrateBtn()){

            result.setPoly(op.integrate(pol1));
        }
        view.setTextResult(result.convertToString());
    }
}
