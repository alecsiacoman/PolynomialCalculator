package Model;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

public class Operations {

    public TreeMap<Integer,Double> additionOrSubtraction(Polynomial pol1, Polynomial pol2, int operation){
        TreeMap<Integer, Double> result = pol1.getPoly();
        pol2.getPoly().forEach((d, c) -> {
            if(result.containsKey(d))
                if(operation == 0)
                    result.put(d, result.get(d) + c);
                else
                    result.put(d, result.get(d) - c);
            else
                result.put(d, c);
        });
        return result;
    }

    public TreeMap<Integer,Double> multiplication(Polynomial pol1, Polynomial pol2){
        TreeMap<Integer, Double> result = new TreeMap();
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
        if(pol1.getPoly().firstKey() < pol2.getPoly().firstKey()){ //interchange
            TreeMap<Integer, Double> auxTree = pol1.getPoly();
            pol1.getPoly().clear();
            pol1.getPoly().putAll(pol2.getPoly());
            pol2.getPoly().clear();
            pol2.getPoly().putAll(auxTree);
        }
    }

//    public Polynomial division(Polynomial pol1, Polynomial pol2){
//        Polynomial quotient = new Polynomial();
//        Polynomial remainder = new Polynomial();
//        //remainder is actually pol1 and quotient is result poly, aka res
////        System.out.println(pol1.getPoly().firstKey() + " " + pol2.getPoly().firstKey());
////        interchangePolynomials(pol1, pol2);
////        System.out.println(pol1.convertToString());
////        System.out.println(pol2.convertToString());
////        System.out.println(pol1.getPoly().firstEntry().getValue() + " " + pol2.getPoly().firstEntry().getValue());
//
//        ///*
//        while(!pol1.getPoly().isEmpty() && !pol2.getPoly().isEmpty() && pol1.getPoly().firstKey() >= pol2.getPoly().firstKey()){ //do these steps while remainder's degree is greater than the quotient's
////            System.out.println(pol1.getPoly().firstKey() + " " + pol2.getPoly().firstKey());
//            System.out.println(pol1.convertToString());
//            System.out.println(pol2.convertToString());
//            System.out.println(pol1.getPoly().firstEntry().getValue() + " " + pol2.getPoly().firstEntry().getValue());
//            interchangePolynomials(pol1, pol2);
//            int d = pol1.getPoly().firstKey() - pol2.getPoly().firstKey();
//            double c = pol1.getPoly().firstEntry().getValue() / pol2.getPoly().firstEntry().getValue();
//
//            System.out.println(d + " " + c);
//            quotient.getPoly().put(d, c);
//            System.out.println(quotient.convertToString());
//
//           // System.out.println(multiplication(quotient, pol2).convertToString());
//            remainder = additionOrSubtraction(pol1, multiplication(quotient, pol2), 1);
//           // System.out.println(remainder.convertToString());
//            pol1.getPoly().clear();
//            pol1.getPoly().putAll(remainder.getPoly());
//        //    System.out.println(pol1.convertToString());
//        }
////*/
//
//        return quotient;
//    }

    public TreeMap<Integer,Double> derivative(Polynomial pol1){
        TreeMap<Integer, Double> result = new TreeMap<>();
        for(Map.Entry<Integer, Double> entry : pol1.getPoly().entrySet()){
            int degree = entry.getKey();
            double coeff = entry.getValue();
            if(degree > 0 )
                result.put(degree - 1, coeff * degree);
        }
        return result;
    }

    public TreeMap<Integer,Double> integrate(Polynomial pol1){
        TreeMap<Integer, Double> result = new TreeMap<>();
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
