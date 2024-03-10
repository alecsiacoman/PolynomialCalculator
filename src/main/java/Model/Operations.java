package Model;
import Model.Polynomial;

import java.util.HashMap;
import java.util.Map;

public class Operations {

    private Polynomial res = new Polynomial();
    public Polynomial addOrSubtractPolynomials(Polynomial pol1, Polynomial pol2, int operation){
        res.getPoly().clear();
        pol1.getPoly().forEach((d1, c1) -> {
            pol2.getPoly().forEach((d2, c2) -> {
                if(d1 == d2){
                    if(operation == 0) //add
                         res.getPoly().put(d1, c1 + c2);
                    else
                        if(operation == 1) //subtract
                             res.getPoly().put(d1, c1 - c2);
                }
            });
        });
        return res;
    }

    public Polynomial getRes() {
        return res;
    }
}
