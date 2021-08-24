package a_practiceproblems.stacks.expression;

import java.util.Stack;
import java.util.function.Function;

public class InfixToPostfix {
    public static String infixToPostfix(String infixExpression) {
        Function<Character, Integer> precedence = operand ->
        {
            switch (operand) {
                case '^':
                    return 3;
                case '*':
                case '/':
                    return 2;
                case '+':
                case '-':
                    return 1;
            }
            return Integer.MAX_VALUE;
        };
        Stack<Character> stack = new Stack<>();
        StringBuilder postFixExpression = new StringBuilder();
        for (char c : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                postFixExpression.append(c);
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    postFixExpression.append(stack.pop());
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence.apply(stack.peek()) > precedence.apply(c))
                    postFixExpression.append(stack.pop());
                stack.push(c);
            }
        }
        while (!stack.isEmpty())
            postFixExpression.append(stack.pop());

        return postFixExpression.toString();
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b"));
    }
}
