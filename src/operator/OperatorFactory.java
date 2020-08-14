package operator;

import java.util.Map;

public class OperatorFactory {

    private static Map<String, Operator> mapping = Map.of("+", new Addition(), "-", new Subtraction(), "*", new Multiplication(), "/", new Division());

    /**
     * Makes a class which can perform a mathematical expression corresponding the mathematical symbol given
     * @param operator a mathematical symbol
     * @return a class which can evaluate the given symbol
     */
    public static Operator fromString(String operator) {
        return mapping.get(operator);
    }

}
