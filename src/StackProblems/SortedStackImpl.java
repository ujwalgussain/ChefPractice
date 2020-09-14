package StackProblems;

import java.util.Stack;

public class SortedStackImpl {

    static void sort(Stack<Integer> s)
    {
        if(s.isEmpty())
            return;
        int top=s.pop();
        sort(s);
        sortedInsert(s,top);
    }
    static void sortedInsert(Stack<Integer> s,int element)
    {
        if(s.isEmpty() || element>s.peek())
        {
            s.push(element);
            return;
        }
        int top=s.pop();
        sortedInsert(s,element);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s= new Stack<>();
        s.push(10);
        s.push(5);
        s.push(20);
        s.push(1);
        System.out.println("Stack-> "+s);
        sort(s);
        System.out.println("After sort ->" + s);

    }
}
