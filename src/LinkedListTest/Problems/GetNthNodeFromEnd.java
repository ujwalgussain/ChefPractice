package LinkedListTest.Problems;

import LinkedListTest.LLNode;
import LinkedListTest.LinkedList;

public class GetNthNodeFromEnd {
    public static LLNode getNthNodefromEnd(LinkedList l,int n)
    {
        //LinkedList l = LinkedListUtils.NORMAL;
        LLNode temp=l.head;
        int c=0;
        while(temp!=null && c<n)
        {
            temp=temp.next;c++;
        }
        if(temp==null)
            return null;
        LLNode nthLastNode = l.head;
        while(temp != null)
        {
            temp=temp.next;
            nthLastNode=nthLastNode.next;
        }
        return nthLastNode;

    }
}
