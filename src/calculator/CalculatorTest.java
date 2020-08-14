package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator = new Calculator();
    final double eps = 0.00000001;

    @Test
    void evaluate() {
        String[] postfix1 = new String[]{"3","4","+"};
        double r1 = 7;
        String[] postfix2 = new String[]{"3", "4", "2" ,"*", "1", "5", "-" , "/", "+"};
        double r2 = 1;
        String[] postfix3 = new String[]{"5", "30", "2.2" ,"*", "1", "5.5", "2" , "*", "-", "/", "+"};
        double r3 = -1.6;

        assertNearEqual(calculator.evaluate(postfix1), r1, eps);
        assertNearEqual(calculator.evaluate(postfix2), r2, eps);
        assertNearEqual(calculator.evaluate(postfix3), r3, eps);
    }

    void assertNearEqual(double x, double y, double error_margin){
        assertTrue(Math.abs(x-y) < error_margin);
    }
}