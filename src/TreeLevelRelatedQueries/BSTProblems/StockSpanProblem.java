package TreeLevelRelatedQueries.BSTProblems;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] price={ 10, 4, 5, 90, 120, 80 };
        int[] S= new int[price.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < price.length; i++) {
            while(!stack.isEmpty() && price[i]>= price[stack.peek()])
                stack.pop();
            S[i] = stack.isEmpty()?i+1:i - stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(S));
    }
}
