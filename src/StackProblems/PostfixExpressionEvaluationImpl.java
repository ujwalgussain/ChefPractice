package StackProblems;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixExpressionEvaluationImpl {
    static int calculate(int a, int b,String operator)
    {

        switch (operator)
        {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
        }
        return 0;
    }
    static int evaluatePostfixExpression(String expression)
    {
        /*
            Scan the Expression from Left to Right
            IF current character is Digit
            then push it in stack
          ELSE
            pop 2 elements from stack
            push(pop2-pop1)
        * */
        Stack<Integer> stack = new Stack<>();

        for(String s: expression.split("\\s"))
        {
            if(s.length()==1 && !Character.isDigit(s.charAt(0)))
            {
                //pop 2 elements from the stack and perform operation

                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(calculate(operand1,operand2,s));
                System.out.println(String.format("%d %s %d = %d",operand1,s,operand2,stack.peek() ));
            }
            else
            {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
    static int evaluatePrefixExpression(String expression)
    {
        /*
          Scan the Expression from Right to Left
          IF current character is Digit
                then push it in stack
          ELSE
            pop 2 elements from stack
            push(pop1-pop2)
        * */

        Stack<Integer> stack = new Stack<>();
        String[] tokens=expression.split("\\s");
        for (int i = tokens.length-1; i >=0; i--)
        {
            String s = tokens[i];
            if(s.length()==1 && !Character.isDigit(s.charAt(0)))
            {
                //pop 2 elements from the stack and perform operation

                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(calculate(operand1,operand2,s));
                System.out.println(String.format("%d %s %d = %d",operand1,s,operand2,stack.peek() ));
            }
            else
            {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
    public static void main(String[] args) {
        System.out.println(evaluatePostfixExpression("2 3 1 * + 9 -"));
        System.out.println(evaluatePrefixExpression("- + 8 / 6 3 2"));
    }
}
