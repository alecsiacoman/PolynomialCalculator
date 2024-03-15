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
        pol1.convertToPolynomial("x^3 - 2x^2 + 6x - 5");
        pol2.convertToPolynomial("x^2 - 1");
    }

    @Test
    public void additionTest(){
        TreeMap<Integer, Double> result = new TreeMap<>(Comparator.reverseOrder());
        result.put(3, 1.0);
        result.put(2, -1.0);
        result.put(1, 6.0);
        result.put(0, -6.0);
        assertEquals(op.addition(pol1, pol2), result);

    }

    @Test
    public void subtractionTest(){
        TreeMap<Integer, Double> result = new TreeMap<>(Comparator.reverseOrder());
        result.put(3, 1.0);
        result.put(2, -3.0);
        result.put(1, 6.0);
        result.put(0, -4.0);
        assertEquals(op.subtraction(pol1, pol2), result);
    }

    @Test
    public void multiplicationTest(){
        TreeMap<Integer, Double> result = new TreeMap<>(Comparator.reverseOrder());
        result.put(5, 1.0);
        result.put(4, -2.0);
        result.put(3, 5.0);
        result.put(2, -3.0);
        result.put(1, -6.0);
        result.put(0, 5.0);
        assertEquals(op.multiplication(pol1, pol2), result);
    }

    @Test
    public void divisionTest(){
        TreeMap<Integer, Double>[] result = new TreeMap[2];
        result[0] = new TreeMap<>(Comparator.reverseOrder());
        result[1] = new TreeMap<>(Comparator.reverseOrder());
        result[0].put(1, 1.0);
        result[0].put(0, -2.0);
        result[1].put(1, 7.0);
        result[1].put(0, -7.0);
        TreeMap<Integer, Double>[] divide = new TreeMap[2];
        divide = op.division(pol1, pol2);
        assertEquals(divide[0], result[0]);
        assertEquals(divide[1], result[1]);
    }

    @Test
    public void derivationTest(){
        TreeMap<Integer, Double> result = new TreeMap<>(Comparator.reverseOrder());
        result.put(2, 3.0);
        result.put(1, -4.0);
        result.put(0, 6.0);
        assertEquals(op.derivative(pol1), result);
    }

    @Test
    public void integrationTest(){
        TreeMap<Integer, Double> result = new TreeMap<>(Comparator.reverseOrder());
        result.put(4, 0.25);
        result.put(3, -0.67);
        result.put(2, 3.0);
        result.put(1, -5.0);
        assertEquals(op.integrate(pol1), result);
    }
}
