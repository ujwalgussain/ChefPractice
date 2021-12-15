package a_practiceproblems.linkedlistproblems.Problems;

import a_practiceproblems.linkedlistproblems.LLNode;


public class GetNthNode {
    public static LLNode getNthNode(LLNode head, int n)
    {
        //LinkedList l = LinkedListUtils.NORMAL;
        int c=1;
        LLNode res=null;
        LLNode temp=head;
        while(temp!=null)
        {
            temp=temp.next;
            if(c==n-1)
            {
                res=temp;break;
            }
            c++;
        }
        return res;

    }
}
