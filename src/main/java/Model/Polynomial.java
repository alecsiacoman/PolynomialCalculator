package Model;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Polynomial {
    private TreeMap<Integer, Double> poly = new TreeMap<>(Comparator.reverseOrder());

    public void convertToPolynomial(String str){
        str = str.replace(" - ", " + -");
        String[] monomials = str.split("\\s*\\+\\s*");
        double coeff = 0;
        int degree = 0;
        for(String mono: monomials){
            if(!mono.isEmpty()){
                if(mono.contains("x^")) {
                    String[] elem = mono.split("x\\^?"); //split by coefficient and degree
                    try {
                        if (elem[0].equals("-"))
                            coeff = -1;
                        else
                            coeff = elem[0].trim().isEmpty() ? 1 : Double.parseDouble(elem[0].trim());
                        degree = Integer.parseInt(elem[1].trim());
                    } catch (NumberFormatException e) {
                        showError("Invalid polynomial! Please respect the example.");
                        return;
                    }
                }
                else{
                    if(mono.contains("x")){
                        if(mono.length() == 2 && mono.contains("-"))
                            coeff = -1;
                        else
                            coeff = mono.length() == 1 ? 1 : Double.parseDouble(mono.substring(0, mono.length() - 1));
                        degree = 1;
                    }
                    else{
                        try{
                            coeff = Double.parseDouble(mono);
                            degree = 0;
                        }catch (NumberFormatException e) {
                            showError("Invalid coefficient: " + mono);
                            return;
                        }
                    }
                }
            }
            poly.put(degree, coeff);
        }
    }

    private void showError(String message){
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public String convertToString(){
        String polyString;
        DecimalFormat df = new DecimalFormat("#.##");
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
                    sb.append(df.format(Math.abs(coeff)));
                }
                if(degree > 1)
                    sb.append("x^").append(degree);
                else if (degree == 1) {
                    sb.append("x");
                }
            }
        });
        polyString = sb.length() == 0 ? "0" : sb.toString();
        return polyString;
    }

    public TreeMap<Integer, Double> getPoly() {
        return poly;
    }

    public int getDegree(){
        return poly.firstKey();
    }
    public double getCoefficient(){
        int degree = this.getDegree();
        return poly.get(degree);
    }

    public void put(int degree, double coeff){
        poly.put(degree, coeff);
    }
}
