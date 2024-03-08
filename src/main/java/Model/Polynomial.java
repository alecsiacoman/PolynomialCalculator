package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Polynomial {
    private HashMap<Integer,Integer> poly = new HashMap<>();

    public Polynomial(String polyString){
        int coeff = 0, degree = 0;

        String[] monos = polyString.split("\\+ ");
        for (String str: monos) {
            //represent the coefficient
            if(str.indexOf("x") == 0)
                coeff = 1;
            else{
                if(str.indexOf("x") == -1){
                    if(str.contains(" "))
                        coeff = Integer.parseInt(str.substring(0, str.length() - 1));
                    else
                        coeff = Integer.parseInt(str);
                }
                else
                    coeff = Integer.parseInt(str.substring(0, str.indexOf("x")));
            }

            //represent the degree
            if(str.contains("x^")) {    //degree greater than 1
                degree = Integer.parseInt(str.substring(str.indexOf('^') + 1, str.indexOf(' ')));
            }
            else if (str.contains("x")){
                degree = 1;
            } else degree = 0;
            poly.put(degree, coeff);
        }
    }

    public HashMap<Integer,Integer> getPoly() {
        return poly;
    }
}
