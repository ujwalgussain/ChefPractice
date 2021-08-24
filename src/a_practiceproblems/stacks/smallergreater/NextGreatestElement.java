package a_practiceproblems.stacks.smallergreater;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatestElement {
    static void find(int[] A)
    {
        int N = A.length;
        int nge[] = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i = N-1;i>=0;i--)
        {
            while(!stack.isEmpty() && stack.peek()<A[i])
                stack.pop();
            if(stack.isEmpty()) {
                nge[i] = -1;
                stack.push(A[i]);
            }
            else
                nge[i] = stack.peek();
        }

        System.out.println(Arrays.toString(nge));
    }

    public static void main(String[] args) {
        find(new int[]{6, 8, 10, 7, 9});
    }
}
