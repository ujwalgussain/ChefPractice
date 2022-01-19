package a_practiceproblems.ArrayProblems;

import java.util.Stack;

public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr=='('){
                stack.push(i);
            }else{
                if(!stack.isEmpty())
                    stack.pop();
                if(!stack.isEmpty())
                    maxLen = Math.max(maxLen,i-stack.peek());
                else
                    stack.push(i);
            }
        }
        return maxLen;
    }
}
