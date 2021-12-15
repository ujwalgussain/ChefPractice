package a_practiceproblems.linkedlistproblems.Problems.ReversingLL;

import a_practiceproblems.linkedlistproblems.LLNode;

public class ReorderingList {
    //https://www.interviewbit.com/problems/reorder-list/

    /*Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
    reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
    You must do this in-place without altering the nodes’ values.

            For example,

    Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/
    public LLNode reorderList(LLNode A) {
        if(A==null)
            return null;
        LLNode middle = findMiddle(A);
        LLNode l2 = middle.next;
        middle.next=null;
        LLNode reversedmid  = reverse(l2);
        middle = A;
        while(reversedmid != null)
        {
            LLNode next1 = middle.next;
            LLNode next2 = reversedmid.next;
            middle.next = reversedmid;
            reversedmid.next = next1;
            middle = next1;
            reversedmid = next2;
        }
        return A;

    }

    public LLNode findMiddle(LLNode A) {
        LLNode f = A, s = A;
        while(f != null && f.next!=null)
        {
            f = f.next.next;
            s= s.next;
        }
        return s;
    }

    public LLNode reverse(LLNode A)
    {
        LLNode prev = null;
        LLNode curr = A;
        while(curr != null)
        {
            LLNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
