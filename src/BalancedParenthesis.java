import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String[] args) {
        System.out.println(isBalancedParenthesis("a(bcd)d"));
        System.out.println(isBalancedParenthesis("(kjds(hfkj)sdhf"));
        System.out.println(isBalancedParenthesis("(sfdsf)(fsfsf"));
        System.out.println(isBalancedParenthesis("{[]}()"));
        System.out.println(isBalancedParenthesis("{[}]"));
    }

    private static boolean isBalancedParenthesis(String input) {
        Stack<Character> stack = new Stack<>();
        Set<Character> openParenthesis = new HashSet<>(Arrays.asList('(', '[', '{'));
        Set<Character> closedParenthesis = new HashSet<>(Arrays.asList(')', ']', '}'));
        for (char c : input.toCharArray()) {
            if (openParenthesis.contains(c)) {
                stack.push(c);
            } else if (closedParenthesis.contains(c)) {
                if (stack.isEmpty() || !isParenthesisMatch(stack.peek(), c)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private static boolean isParenthesisMatch(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

}
