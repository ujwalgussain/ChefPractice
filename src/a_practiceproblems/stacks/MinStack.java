package a_practiceproblems.stacks;

import java.util.Stack;

public class MinStack {
    //https://leetcode.com/problems/min-stack/discuss/1707764/my-java-solution
    Stack<int[]> stack = new Stack<>();
    int minVal = -1;

    public MinStack() {

    }

    public void push(int val) {
        if (stack.isEmpty())
            stack.push(new int[]{val, val});
        else
            stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
