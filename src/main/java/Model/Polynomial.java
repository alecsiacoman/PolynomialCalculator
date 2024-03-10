package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Polynomial {
    private HashMap<Integer,Double> poly = new HashMap<>();

    public void convertToPolynomial(String str){
        str = str.replace(" - ", " + -");
        String[] monomials = str.split("\\s*\\+\\s*");
        double coeff = 0;
        int degree = 0;
        for(String mono: monomials){
            if(mono.contains("x^")){
                String[] elem = mono.split("x\\^?"); //split by coefficient and degree
                coeff = elem[0].trim().isEmpty() ? 1 : Double.parseDouble(elem[0].trim());
                degree = Integer.parseInt(elem[1].trim());
            }
            else{
                if(mono.contains("x")){
                    coeff = mono.length() == 1 ? 1 : Double.parseDouble(mono.substring(0, mono.length() - 1));
                    degree = 1;
                }
                else{
                    coeff = Double.parseDouble(mono);
                    degree = 0;
                }
            }
            poly.put(degree, coeff);
        }
    }

    public String convertToString(){
        String polyString;
        StringBuilder sb = new StringBuilder();
        poly.forEach((degree, coeff) ->
        {
            if(coeff != 0){
                if(sb.length() == 0 && coeff < 0)
                    sb.append("- ");
                else
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
        polyString = sb.length() == 0 ? "0" : sb.toString();
        return polyString;
    }

    public HashMap<Integer,Double> getPoly() {
        return poly;
    }
}
