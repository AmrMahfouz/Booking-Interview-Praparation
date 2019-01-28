package careercup;

import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(isBalanced("{{}}{)([][]"));
        System.out.println(isBalanced("{{}}{()}([][])"));
    }

    private static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (isOpenBracket(c)) {
                stack.push(c);
            } else if (isCloseBracket(c)) {
                char openBracket = stack.pop();
                if (!isBracketsMatching(openBracket, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isBracketsMatching(char openBracket, char closeBracket) {
        return openBracket == '(' && closeBracket == ')' ||
                openBracket == '{' && closeBracket == '}' ||
                openBracket == '[' && closeBracket == ']';
    }

    private static boolean isOpenBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private static boolean isCloseBracket(char c) {
        return c == ')' || c == '}' || c == ']';
    }

}
