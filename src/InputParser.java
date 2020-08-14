import utils.NumberUtils;

import java.util.*;

public class InputParser {

    static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    private Map<String, Integer> precedenceMap = Map.of("+", 2, "-", 2, "*", 3, "/", 3, "(", 0, ")", 1);

    /**
     * Converts a raw user input to a post fix notation formatted in a primitive array
     *
     * @param input raw user input
     * @return postfix notation
     */
    public String[] postFix(String input) {
        Stack<String> queue = new Stack();
        Stack<String> opsStack = new Stack<>();
        input = clean(input);
        String[] exs = input.split(String.format(WITH_DELIMITER, "\\+|\\-|\\*|\\/|\\(|\\)|\\^"));

        for (String token : exs) {
            if (NumberUtils.isNumber(token)) // Number (if not incorrect input)
            {
                queue.push(token);
            } else if (NumberUtils.isOperator(token)) {  // Operator
                if (!opsStack.empty()) {
                    String top = opsStack.peek();
                    while (!opsStack.empty() && (
                            precedenceMap.get(top) > precedenceMap.get(token) || precedenceMap.get(top).equals(precedenceMap.get(token))
                    ) && !top.equals("(")) {
                        queue.push(opsStack.pop());
                        top = opsStack.peek();
                    }
                }
                opsStack.push(token);
            } else if (token.equals("(")) {
                opsStack.push(token);
            } else if (token.equals(")")) {
                while (!opsStack.empty() && !opsStack.peek().equals("(")) {
                    queue.push(opsStack.pop());
                }
                if (!opsStack.empty() && opsStack.peek().equals("(")) {
                    opsStack.pop();
                }
            }
        }
        while (!opsStack.empty()) {
            queue.push(opsStack.pop());
        }
        return queue.toArray(new String[]{});
    }

    private String clean(String dirtyInput) {
        return dirtyInput.replace(" ", "").replace(",",".");
    }


}