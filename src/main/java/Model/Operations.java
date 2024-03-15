package Model;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Operations {

    public TreeMap<Integer,Double> addition(Polynomial pol1, Polynomial pol2){
        TreeMap<Integer, Double> result = new TreeMap<>(pol1.getPoly());
        TreeMap<Integer, Double> treeMap = pol1.getPoly();
        pol2.getPoly().forEach((d, c) -> {
            if(treeMap.containsKey(d))
            {
                double coeff = treeMap.get(d);
                if(coeff + c != 0.0)
                        result.put(d, coeff + c);
                else
                    result.remove(d);
            }
            else
                result.put(d, c);
        });
        return result;
    }

    public TreeMap<Integer,Double> subtraction(Polynomial pol1, Polynomial pol2){
        TreeMap<Integer, Double> result = new TreeMap<>(pol1.getPoly());
        TreeMap<Integer, Double> treeMap = pol1.getPoly();
        pol2.getPoly().forEach((d, c) -> {
            if(treeMap.containsKey(d))
            {
                double coeff = treeMap.get(d);
                if(coeff - c != 0.0)
                    result.put(d, coeff - c);
                else
                    result.remove(d);
            }
            else
                result.put(d, -c);
        });
        return result;
    }

    public TreeMap<Integer,Double> multiplication(Polynomial pol1, Polynomial pol2){
        TreeMap<Integer, Double> result = new TreeMap(Comparator.reverseOrder());
        pol1.getPoly().forEach((d1, c1) -> {
            pol2.getPoly().forEach((d2, c2) -> {
                double coeff = c1 * c2;
                if(result.containsKey(d1 + d2))
                    coeff += result.get(d1 + d2);
                result.put(d1 + d2, coeff);
            });
        });
        return result;
    }

    private void interchangePolynomials(Polynomial pol1, Polynomial pol2){
        if(pol1.getDegree() < pol2.getDegree()){
            TreeMap<Integer, Double> auxTree = pol1.getPoly();
            pol1.setPoly(pol2.getPoly());
            pol2.setPoly(auxTree);
        }
    }

    public TreeMap<Integer, Double>[] division(Polynomial pol1, Polynomial pol2){
        interchangePolynomials(pol1, pol2); //pol1 - dividend; pol2 - divisor

        Polynomial quotient = new Polynomial();
        while(pol1.getDegree() >= pol2.getDegree()){
            int newDegree = pol1.getDegree() - pol2.getDegree();
            double newCoeff = pol1.getCoefficient() / pol2.getCoefficient();
            quotient.getPoly().put(newDegree, newCoeff);

            Polynomial partialQuotient = new Polynomial();
            partialQuotient.getPoly().put(newDegree, newCoeff);
            Polynomial multiplicationResult = new Polynomial();
            multiplicationResult.setPoly(multiplication(partialQuotient, pol2));

            Polynomial subtractResult = new Polynomial();
            subtractResult.setPoly(subtraction(pol1, multiplicationResult));
            pol1 = subtractResult;
        }
        return new TreeMap[]{quotient.getPoly(), pol1.getPoly()};
    }

    public TreeMap<Integer,Double> derivative(Polynomial pol1){
        TreeMap<Integer, Double> result = new TreeMap<>(Comparator.reverseOrder());
        for(Map.Entry<Integer, Double> entry : pol1.getPoly().entrySet()){
            int degree = entry.getKey();
            double coeff = entry.getValue();
            if(degree > 0 )
                result.put(degree - 1, coeff * degree);
        }
        return result;
    }

    public TreeMap<Integer,Double> integrate(Polynomial pol1){
        TreeMap<Integer, Double> result = new TreeMap<>(Comparator.reverseOrder());
        DecimalFormat df = new DecimalFormat("#.##");
        for(Map.Entry<Integer, Double> entry : pol1.getPoly().entrySet()){
            int degree = entry.getKey();
            double coeff = entry.getValue();
            Double final_coeff = Double.parseDouble(df.format(coeff / (degree + 1)));
            result.put(degree + 1,  final_coeff);
        }
        return result;
    }

}
