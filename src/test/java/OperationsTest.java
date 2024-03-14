import Model.Operations;
import Model.Polynomial;
import com.sun.source.tree.Tree;
import jdk.dynalink.Operation;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class OperationsTest {
    private Operations op;
    private Polynomial pol1, pol2;

    @BeforeEach
    public void setup(){
        op = new Operations();
        pol1 = new Polynomial();
        pol2 = new Polynomial();
        pol1.convertToPolynomial("x^3 + 1");
        pol2.convertToPolynomial("x^3 + x^2 - 2");
    }

    @Test
    public void additionTest(){
        TreeMap<Integer, Double> result = new TreeMap<>(Comparator.reverseOrder());
        result.put(3, 2.0);
        result.put(2, 1.0);
        result.put(0, -1.0);
        assertEquals(op.addition(pol1, pol2), result);

    }

    @Test
    public void subtractionTest(){
        TreeMap<Integer, Double> result = new TreeMap<>(Comparator.reverseOrder());
        result.put(2, -1.0);
        result.put(0, 3.0);
        assertEquals(op.subtraction(pol1, pol2), result);

    }

    @Test
    public void multiplicationTest(){
        TreeMap<Integer, Double> result = new TreeMap<>(Comparator.reverseOrder());
        result.put(6, 1.0);
        result.put(5, 1.0);
        result.put(3, -1.0);
        result.put(2, 1.0);
        result.put(0, -2.0);
        assertEquals(op.multiplication(pol1, pol2), result);
    }
}
