package a_practiceproblems.stacks.expression;

import java.util.Stack;

public class PostfixToPrefix {
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
    public static String postfixToPrefixExpression(String postfixExpression)
    {
        Stack<String> expressionStack = new Stack<>();
        for (char c: postfixExpression.toCharArray())
        {
            if(isOperator(c))
            {
                String operand2 = expressionStack.pop();
                String operand1 = expressionStack.pop();
                expressionStack.push(String.format("%s%s%s",c,operand1,operand2));
            }
            else
                expressionStack.push(Character.toString(c));
        }
        if(expressionStack.size() != 1)
            throw new RuntimeException("Invalid Postfix Expression");
        return expressionStack.pop();
    }

    public static void main(String[] args) {
        /*
            Input :  Postfix : ABC/-AK/L-*
            Output : Prefix :  *-A/BC-/AKL
        */
        System.out.println(postfixToPrefixExpression("ABC/-AK/L-*"));
    }
}
