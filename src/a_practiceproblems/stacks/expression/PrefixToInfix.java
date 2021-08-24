package a_practiceproblems.stacks.expression;

import java.util.Stack;

public class PrefixToInfix {
    static boolean isOperator(char c)
    {
        switch (c)
        {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
        }
        return false;
    }
    public static String prefixToInfixExpression(String prefixExpression)
    {
        Stack<String> expressionStack = new Stack<>();
        for (int i = prefixExpression.length()-1; i >=0 ; i--)
        {
            char c = prefixExpression.charAt(i);
            if(isOperator(c))
            {
                expressionStack.push(String.format("(%s%s%s)",expressionStack.pop(),c,expressionStack.pop()));
            }
            else
                expressionStack.push(Character.toString(c));
        }
        if(expressionStack.size() != 1)
            throw new RuntimeException("Invalid Prefix Expression");
        return expressionStack.pop();
    }

    public static void main(String[] args) {
        System.out.println(prefixToInfixExpression("*-A/BC-/AKL"));
    }
}
