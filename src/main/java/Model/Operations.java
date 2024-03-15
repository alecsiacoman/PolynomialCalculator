package Model;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Operations {

    public Polynomial addition(Polynomial pol1, Polynomial pol2){
        Polynomial result = pol1;
        TreeMap<Integer, Double> treeMap = pol1.getPoly();
        pol2.getPoly().forEach((d, c) -> {
            if(treeMap.containsKey(d))
            {
                double coeff = treeMap.get(d);
                if(coeff + c != 0.0)
                    result.put(d, coeff + c);
                else
                    result.getPoly().remove(d);
            }
            else
                result.put(d, c);
        });
        return result;
    }

    public Polynomial subtraction(Polynomial pol1, Polynomial pol2){
        Polynomial result = pol1;
        TreeMap<Integer, Double> treeMap = pol1.getPoly();
        pol2.getPoly().forEach((d, c) -> {
            if(treeMap.containsKey(d))
            {
                double coeff = treeMap.get(d);
                if(coeff - c != 0.0)
                    result.put(d, coeff - c);
                else
                    result.getPoly().remove(d);
            }
            else
                result.put(d, -c);
        });
        return result;
    }

    public Polynomial multiplication(Polynomial pol1, Polynomial pol2){
        Polynomial result = new Polynomial();
        pol1.getPoly().forEach((d1, c1) -> {
            pol2.getPoly().forEach((d2, c2) -> {
                double coeff = c1 * c2;
                if(result.getPoly().containsKey(d1 + d2))
                    coeff += result.getPoly().get(d1 + d2);
                result.put(d1 + d2, coeff);
            });
        });
        return result;
    }

    private void interchangePolynomials(Polynomial pol1, Polynomial pol2){
        if(pol1.getDegree() < pol2.getDegree()){
            Polynomial auxTree = pol1;
            pol1 = pol2;
            pol2 = auxTree;
        }
    }

    public Polynomial[] division(Polynomial pol1, Polynomial pol2){
        interchangePolynomials(pol1, pol2); //pol1 - dividend; pol2 - divisor

        Polynomial quotient = new Polynomial();
        while(pol1.getDegree() >= pol2.getDegree()){
            int newDegree = pol1.getDegree() - pol2.getDegree();
            double newCoeff = pol1.getCoefficient() / pol2.getCoefficient();
            quotient.getPoly().put(newDegree, newCoeff);

            Polynomial partialQuotient = new Polynomial();
            partialQuotient.getPoly().put(newDegree, newCoeff);
            Polynomial multiplicationResult = new Polynomial();
            multiplicationResult = multiplication(partialQuotient, pol2);

            Polynomial subtractResult = new Polynomial();
            subtractResult = subtraction(pol1, multiplicationResult);
            pol1 = subtractResult;
        }
        return new Polynomial[]{quotient, pol1};
    }

    public Polynomial derivative(Polynomial pol1){
        Polynomial result = new Polynomial();
        pol1.getPoly().forEach((d, c) -> {
            if(d > 0)
                result.put(d - 1, c * d);
        });
        return result;
    }

    public Polynomial integrate(Polynomial pol1){
        Polynomial result = new Polynomial();
        DecimalFormat df = new DecimalFormat("#.##");
        pol1.getPoly().forEach((d, c) -> {
           double final_c = Double.parseDouble(df.format(c / (d + 1)));
           result.put(d + 1, final_c);
        });
        return result;
    }

}
