package a_practiceproblems.stacks.smallergreater;

import java.util.Arrays;
import java.util.Stack;

public class FindNextOrPreviousGreaterElement {
    /*
    * Logic:
    *   Next/Previous Greater -> maintain stack in descending order push everytime
    *   Next/Previous Greatest -> maintain stack in descending order push only if stack is empty
    * */
    static boolean isStackUnEmptyAndTopIsSmallerThanOrEqualToCurrentElement(Stack<Integer> stack, int currElement){
        return !stack.isEmpty() && stack.peek()<=currElement;
    }

    static void findNextGreaterElement(int[] A)
    {
        int N = A.length;
        int nge[] = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i = N-1;i>=0;i--)
        {
            //Ensuring Stack should have elements in descending order
            while(isStackUnEmptyAndTopIsSmallerThanOrEqualToCurrentElement(stack,A[i]))
                stack.pop();
            if(stack.isEmpty())
                nge[i] = -1;
            else
                nge[i] = stack.peek();
            stack.push(A[i]);

        }
        System.out.println(Arrays.toString(nge));
    }
    static void findPreviousGreaterElement(int A[])
    {
        int N = A.length;
        int pge[] = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++)
        {
            //stack should have elems in descending order
            while(isStackUnEmptyAndTopIsSmallerThanOrEqualToCurrentElement(stack,A[i]))
                stack.pop();
            pge[i] = (stack.isEmpty())?-1:stack.peek();
            stack.push(A[i]);
        }

        System.out.println(Arrays.toString(pge));
    }

    static void findNextGreatestElement(int[] A)
    {
        int N = A.length;
        int nge[] = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i = N-1;i>=0;i--)
        {
            //Ensuring Stack should have elements in descending order
            while(isStackUnEmptyAndTopIsSmallerThanOrEqualToCurrentElement(stack,A[i]))
                stack.pop();

            if(stack.isEmpty()) {
                //A[i] is the greatest Element
                nge[i] = -1;
                stack.push(A[i]); //Push only if stack is empty
            }
            else
                nge[i] = stack.peek(); //top is the greatest element

        }
        System.out.println(Arrays.toString(nge));
    }

    static void findPreviousGreatestElement(int A[])
    {
        int N = A.length;
        int pge[] = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++)
        {
            //stack should have elems in descending order
            while(isStackUnEmptyAndTopIsSmallerThanOrEqualToCurrentElement(stack,A[i]))
                stack.pop();
            if(stack.isEmpty())
            {
                //A[i] is the greatest Element
                pge[i] = -1;
                stack.push(A[i]);
            }
            else
                pge[i] = stack.peek();//top is the greatest element
        }

        System.out.println(Arrays.toString(pge));
    }

    public static void main(String[] args) {
        int[] input = {6,8,10,7,9};
        findNextGreaterElement(input); //[8, 10, -1, 9, -1]
        findNextGreatestElement(input); //[10, 10, -1, 9, -1]

        int[] reverse_input = {9,7,10,8,6};
        findPreviousGreaterElement(reverse_input);//[-1, 9, -1, 10, 8]
        findPreviousGreatestElement(reverse_input);//[-1, 9, -1, 10, 10]
    }

}
