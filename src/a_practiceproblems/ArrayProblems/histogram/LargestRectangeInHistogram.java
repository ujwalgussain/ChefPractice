package a_practiceproblems.ArrayProblems.histogram;

import java.util.Stack;

public class LargestRectangeInHistogram {
    /*
    Stack should be in increasing order. Hence if top>=current
        pop = stack.pop
                                currIdx.....If stack is Empty
        area = height[pop] X        Or
                                currIdx - top - 1
     */
    public static int largestRectangleArea(int[] heights) {
        //https://www.youtube.com/watch?v=ZmnqCZp9bBs
        Stack<Integer> idxStack = new Stack<>();
        int i=0, maxArea = -1;
        for(;i<heights.length;i++){
            while(!idxStack.isEmpty() && heights[idxStack.peek()]>=heights[i]){
                int pop = idxStack.pop();
                int area = heights[pop] * (idxStack.isEmpty()?i:i-idxStack.peek()-1);
                maxArea = Math.max(maxArea,area);
            }
            idxStack.push(i);
        }
        while(!idxStack.isEmpty()){
            int pop = idxStack.pop();
            int area = heights[pop] * (idxStack.isEmpty()?i:i-idxStack.peek()-1);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
        //Also see Max Rectangular Area in Matrix - src/a_practiceproblems/ArrayProblems/matrix/MaxRectangleArea.java
    }
}
