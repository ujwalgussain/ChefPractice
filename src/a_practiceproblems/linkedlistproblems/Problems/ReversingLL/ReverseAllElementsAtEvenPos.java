package a_practiceproblems.linkedlistproblems.Problems.ReversingLL;

import a_practiceproblems.linkedlistproblems.LLNode;

import java.util.Stack;

public class ReverseAllElementsAtEvenPos {
    //https://www.interviewbit.com/problems/even-reverse/
    public LLNode solve(LLNode A) {
        if(A==null || A.next == null || A.next.next==null)
            return A;
        Stack<LLNode> stack = new Stack<>();
        LLNode curr_prev = A, curr_next= null;
        LLNode curr = A.next;
        while(curr!=null){
            curr_next = curr.next;
            curr_prev.next = curr_next;
            curr.next=null;
            stack.push(curr);
            if(curr_next==null)  //even length should stop here
                break;
            curr_prev=curr_next;
            curr = curr_next.next; //odd length should stop here
        }
        LLNode prev = A;
        curr = A;
        while (!stack.isEmpty()){
            LLNode temp = stack.pop();
            //remove curr and add temp
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
        }
        return A;
    }
}
