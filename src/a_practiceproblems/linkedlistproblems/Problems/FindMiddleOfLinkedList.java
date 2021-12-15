package a_practiceproblems.linkedlistproblems.Problems;

import a_practiceproblems.linkedlistproblems.LLNode;


public class FindMiddleOfLinkedList {
    public static LLNode getMiddleOfLinkedList(LLNode head)
    {
        /*In odd length fastptr will come at lastNode
          In even length fastPtr will come at null
        * */
        //LinkedList l = LinkedListUtils.NORMAL;
        LLNode fastptr=head,slowptr=head;
        while(fastptr!=null && fastptr.next!=null)
        {
            fastptr=fastptr.next.next;
            slowptr=slowptr.next;
        }
        return slowptr;
    }
}
