package a_practiceproblems.stacks.smallergreater;

import java.util.ArrayList;
import java.util.Stack;

public class PreviousOrNextSmallerElement {
    public static  boolean isStackUnEmptyAndTopIsGreaterThanEqualTo(Stack<Integer> s, int currElement)
    {
        return !s.isEmpty() && s.peek()>=currElement;
    }
    public static void prevSmaller(int[] A) {
        Stack<Integer> s =new Stack<>();
        ArrayList<Integer> pse = new ArrayList<>();
        for(int i : A)
        {
            while(isStackUnEmptyAndTopIsGreaterThanEqualTo(s,i))
            {
                s.pop();
            }
            pse.add(s.isEmpty()?-1:s.peek());
            s.push(i);
        }
        System.out.println(pse);
    }
    public static void nextSmaller(int[] A) {
        Stack<Integer> s =new Stack<>();
        ArrayList<Integer> pse = new ArrayList<>();
        for(int i=A.length-1;i>=0;i--)
        {
            while(isStackUnEmptyAndTopIsGreaterThanEqualTo(s,A[i]))
            {
                s.pop();
            }
            pse.add(s.isEmpty()?-1:s.peek());
            s.push(A[i]);
        }
        System.out.println(pse);
    }
    public static void prevSmallest(int[] A) {
        Stack<Integer> s =new Stack<>();
        ArrayList<Integer> pse = new ArrayList<>();
        for(int currElement : A)
        {
            while(!s.isEmpty() && s.peek()>=currElement)
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                pse.add(-1);
                s.push(currElement);
            }
            else
                pse.add(s.peek());

        }
        System.out.println(pse);
    }

    public static void main(String[] args) {
        int[] input =           {6,  8, 10, 2, 7,











































































































































































































































































































































































































































































































































        };
        prevSmaller(input);//   [-1, 6, 8, -1, 2, 7]
        prevSmallest(input);//  [-1, 6, 6, -1, 2, 2]
        nextSmaller(input);
    }
}
