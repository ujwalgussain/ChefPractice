package LinkedListTest.Problems.ReversingLL;

import LinkedListTest.LLNode;
import LinkedListTest.LinkedList;
import LinkedListTest.LinkedListUtils;

public class ReverseLinkedList {
    public static LinkedList reverse(LinkedList l)
    {
        /*
        * 1. HashTable
        * 2. Stacks
        * 3. As shown below
        * */
        LLNode t = l.head,prev=null,next=null;
        while(t!=null)
        {
            next = t.next;
            t.next=prev;
            prev=t;
            t=next;
        }
        l.head=prev;

        return l;
    }

    public static void main(String[] args) {
        System.out.println(reverse((LinkedList) LinkedListUtils.NORMAL.buildAndReturn()));
    }

}
