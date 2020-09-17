package StackProblems;

import java.util.Comparator;
import java.util.Stack;

/*
* Scan the expression from Left to Right
* If current token is a Digit/operand
*   Push in stack
* Else
*   if stack is empty
*       then push the operator
*   Else
*       if current operator is ")"
*           pop all operators until stack is empty OR until 1st "(" is popped
*       if precedence of the current operator<stack top
*           push the current operator in the stack
*       Else pop all operators until current operator < stack top
* After scan is complete Pop all operators from the stack
*
* */
public class InfixToPostFixConversionImpl {
    static int getPrecedence(String operator)
    {
        switch (operator)
        {
            case "(":
            case ")":
                return 0;
            case "+":
            case "-":
                return 1;
            case "/":
            case "*":
                return 2;
            case "^":
                return 3;
        }
        return 0;
    }
    static boolean isFirstOperatorLower(String operator1,String operator2)
    {
        if(getPrecedence(operator1)<getPrecedence(operator2))
        {
            return true;
        }
        return false;

    }
    static String convertInfixToPostfix(String infixExpression)
    {
        StringBuilder postFixExpression=new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(String token:infixExpression.split("\\s"))
        {
            if(token.length()==1 && !Character.isDigit(token.charAt(0)))
            {
                //Operator
                if(stack.isEmpty()) {
                    stack.push(token);
                    continue;
                }
                String top = stack.peek();
                //check for parenthesis
                if(token.equals(")"))
                {
                    //pop until 1st (
                    while(!stack.isEmpty())
                    {
                        String operator = stack.pop();
                        if(operator.equals("("))
                            break;
                        else
                        {
                            postFixExpression.append(operator).append(" ");
                        }
                    }
                }
                else
                {
                    if(!isFirstOperatorLower(top,token))
                    {
                        stack.push(token);
                    }
                    else
                    {
                        while(!stack.isEmpty() && !isFirstOperatorLower(stack.peek(),token))
                        {
                            String operator = stack.pop();
                            postFixExpression.append(operator).append(" ");

                        }
                        stack.push(token);
                    }
                }
            }
            else
            {
                //Operand
                postFixExpression.append(token).append(" ");
            }
        }
        while(!stack.isEmpty())
            postFixExpression.append(stack.pop()).append(" ");
        return postFixExpression.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertInfixToPostfix("( 2 * 3 ) + ( 5 * 4 ) / 6"));
    }
}
