package a_practiceproblems.divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class EvaluateExpressionWithAllPossibilities {
    //https://leetcode.com/problems/different-ways-to-add-parentheses/submissions/
    /*
        2*3-4*5
        *
            2
            3-4*5
            -
                3
                4*5
                *
                    4
                    5   ==> (2*(3-(4*5))
           *
                3-4
                -
                    3
                    4
                5           ==>(2*(3-4)*5)
        -
            2*3
            *
                2
                3
            4*5
            *
                4
                5           ==> (2*3)-(4*5)
        *
            2*3-4
            *
                2
                3-4
                -
                    3
                    4   ==> (2*(3-4)*5)
                5
            -
                2*3
                *
                    2
                    3
                5
     */
    public List<Integer> diffWaysToCompute(String expression) {
        return evaluate(expression);
    }

    public List<Integer> evaluate(String expression) {
        if (expression.length() == 1) //If expression is Single Digit Number
            return List.of(Integer.parseInt(expression));
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            //For Each Operator in Expression: Divide the string and Evaluate
            if (!Character.isDigit(expression.charAt(i))) {
                List<Integer> leftEvaluation = evaluate(expression.substring(0, i));
                List<Integer> rightEvaluation = evaluate(expression.substring(i + 1));
                /*
                For 3*4-5...at this level there will be 2 divisions one for * and other for -
                So we will store the result in List for each operator and pass above
                 */
                for (int left : leftEvaluation) {
                    for (int right : rightEvaluation) {
                        switch (expression.charAt(i)) {
                            case '+':
                                answer.add(left + right);
                                break;
                            case '-':
                                answer.add(left - right);
                                break;
                            case '*':
                                answer.add(left * right);
                                break;
                        }
                    }
                }
            }
        }
        if(answer.size()==0)
            return List.of(Integer.parseInt(expression)); // Corner Case : If Expression contains 2(or more) digit number only
        return answer;
    }
}
