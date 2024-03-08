package Controller;
import Model.Monomial;
import Model.Polynomial;
import View.Calculator;

import java.lang.invoke.SwitchPoint;

public class Operations {

    private String text1 =  "3x^3 + x^2 + 2 + 5x";
    private String text2 = "2x^3 + 3x^2 + 4x + 5";
    private Polynomial pol1 = new Polynomial(text1);
    private Polynomial pol2 = new Polynomial(text2);
    private Polynomial res = new Polynomial(text1);
    private String resString;

    public void addPolynomials(){
        pol2.getPoly().forEach((degree, coeff) ->
        res.getPoly().merge(degree, coeff, Integer::sum));
    }
    public void subtractPolynomial(){
        pol2.getPoly().forEach((degree, coeff) ->
                res.getPoly().merge(degree, -coeff, Integer::sum));
    }


    public void resultConversion(){
        StringBuilder sb = new StringBuilder();
        res.getPoly().forEach((degree, coeff) ->
        {
            if(coeff != 0){
                if(sb.length() > 0){
                    sb.append(coeff > 0 ? " + " : " - ");
                }
                if(Math.abs(coeff) != 1 || degree == 0){
                    sb.append(Math.abs(coeff));
                }
                if(degree > 0)
                    sb.append("x^").append(degree);
            }
        });
        resString = sb.length() == 0 ? "0" : sb.toString();
    }

    public String getResString() {
        return resString;
    }
}
