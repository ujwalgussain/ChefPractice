package a_practiceproblems.stacks;

import java.util.Arrays;
import java.util.Stack;

public class FindPreviousSmallerElement {
    static void find(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[arr.length];
        ans[0] = -1;
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() > arr[i])
                stack.pop();
            if (stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(ans));
    }

    public static void main(String[] args) {
        find(new int[]{2, 5, 3, 7, 8, 1, 9});
    }
}
