import calculator.Calculator;
import utils.NumberUtils;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        InputParser parser = new InputParser();
        Calculator calculator = new Calculator();

        while(true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] postFix = parser.postFix(input);
            double result = calculator.evaluate(postFix);

            System.out.println(String.format("output: %s", NumberUtils.formatPretty(result)));
        }
    }


}
