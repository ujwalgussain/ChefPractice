package a_practiceproblems.linkedlistproblems.Problems;

import a_practiceproblems.linkedlistproblems.LLNode;


public class GetNthNodeFromEnd {
    public static LLNode getNthNodefromEnd(LLNode head,int n)
    {
        //LinkedList l = LinkedListUtils.NORMAL;
        LLNode temp=head;
        int c=0;
        while(temp!=null && c<n)
        {
            temp=temp.next;c++;
        }
        if(temp==null)
            return null;
        LLNode nthLastNode = head;
        while(temp != null)
        {
            temp=temp.next;
            nthLastNode=nthLastNode.next;
        }
        return nthLastNode;

    }
}
