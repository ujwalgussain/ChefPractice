package LinkedListTest.Problems;

import LinkedListTest.LLNode;
import LinkedListTest.LinkedList;
import LinkedListTest.LinkedListUtils;

public class FindMiddleOfLinkedList {
    public static LLNode getMiddleOfLinkedList(LinkedList l)
    {
        /*In odd length fastptr will come at lastNode
           In even length slowptr will come at secondLast node
        * */
        //LinkedList l = LinkedListUtils.NORMAL;
        LLNode fastptr=l.head,slowptr=l.head;
        while(fastptr!=null && fastptr.next!=null)
        {
            fastptr=fastptr.next.next;
            slowptr=slowptr.next;
        }
        return slowptr;
    }
}
