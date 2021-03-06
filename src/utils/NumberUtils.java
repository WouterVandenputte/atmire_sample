package utils;

import java.util.Arrays;
import java.util.List;

public class NumberUtils {

    private final static List<String> operators = Arrays.asList("+", "-", "*", "/");

    public static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean isNumber(char token) {
        return Character.isDigit(token);
    }

    public static boolean isOperator(String token)
    {
        return operators.contains(token);
    }

    public static String formatPretty(double x)
    {
        if(x == (long) x) // if x = integer value
            return String.format("%d",(long)x); // then format as decimal
        else
            return String.format("%s",x);   // else format as 'any type'
    }
}
