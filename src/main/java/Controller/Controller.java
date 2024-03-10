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
        if(source == view.getAddBtn())
            op.additionOrSubtraction(pol1, pol2, 0);
        else if(source == view.getSubtractBtn())
            op.additionOrSubtraction(pol1, pol2, 1);
        else if(source == view.getMultiplyBtn())
            op.multiplication(pol1, pol2);


        view.getTextResult().setText(op.getRes().convertToString());
    }

}
