package Controller;
import Model.Operations;
import Model.Polynomial;
import View.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Calculator view;
    private Operations op = new Operations();
    private Polynomial pol1 = new Polynomial();
    private Polynomial pol2 = new Polynomial();
    private Polynomial res = new Polynomial();


    public Controller(Calculator v){
        this.view = v;
    }

    private void getPolynoms(){
        pol1.convertToPolynomial(view.getTextPolynom1().getText());
        pol2.convertToPolynomial(view.getTextPolynom2().getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        getPolynoms();
        if(source == view.getAddBtn()){
            op.addOrSubtractPolynomials(pol1, pol2, 0);
        }
        else if(source == view.getSubtractBtn())
            op.addOrSubtractPolynomials(pol1, pol2, 1);
        view.getTextResult().setText(op.getRes().convertToString());
    }

}
