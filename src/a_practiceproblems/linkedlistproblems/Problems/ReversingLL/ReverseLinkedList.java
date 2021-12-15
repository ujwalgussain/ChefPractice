package a_practiceproblems.linkedlistproblems.Problems.ReversingLL;

import a_practiceproblems.linkedlistproblems.LLNode;
import a_practiceproblems.linkedlistproblems.LinkedListUtils;

public class ReverseLinkedList {
    public static LLNode reverse(LLNode head)
    {
        /*
        * 1. HashTable
        * 2. Stacks
        * 3. As shown below
        * */
        LLNode t = head,prev=null,next=null;
        while(t!=null)
        {
            next = t.next;
            t.next=prev;
            prev=t;
            t=next;
        }
        head=prev;

        return head;
    }

    public static void main(String[] args) {
        System.out.println(reverse(LinkedListUtils.NORMAL.buildAndReturn()));
    }

}
