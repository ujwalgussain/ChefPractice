package a_practiceproblems.stacks.smallergreater;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterElement {
    static void find(int A[])
    {
        int N = A.length;
        int pge[] = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++)
        {
            while(!stack.isEmpty() && stack.peek()<A[i])
                stack.pop();
            if(stack.isEmpty())
                pge[i] =-1;
            else
                pge[i] = stack.peek();
            stack.push(A[i]);
        }

        System.out.println(Arrays.toString(pge));
    }



    public static void main(String[] args) {
        find(new int[]{5, 1, 4, 3, 6});
    }
}
