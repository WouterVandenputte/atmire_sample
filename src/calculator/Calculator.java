package calculator;

import operator.Operator;
import operator.OperatorFactory;
import utils.NumberUtils;
import java.util.Stack;

public class Calculator {

    /**
     * Calculates a given input
     * @param postFix the input needs to be in postfix notation
     * @return the mathematical evaluation of the postfix input
     */
    public double evaluate(String[] postFix) {
        Stack<Double> vals = new Stack();

        for (String c : postFix) {
            if (NumberUtils.isNumber(c)) {
                vals.push(Double.parseDouble("" + c));
            } else { // Operator
                assert NumberUtils.isOperator(c);
                double val2 = vals.pop();
                double val1 = vals.pop();
                Operator operator = OperatorFactory.fromString(c);
                vals.push(operator.evaluate(val1, val2));
            }
        }
        return vals.pop();
    }
}
