package a_practiceproblems.linkedlistproblems.Problems;

import a_practiceproblems.linkedlistproblems.LLNode;
import a_practiceproblems.linkedlistproblems.LinkedList;

public class GetNthNode {
    public static LLNode getNthNode(LinkedList l, int n)
    {
        //LinkedList l = LinkedListUtils.NORMAL;
        int c=1;
        LLNode res=null;
        LLNode temp=l.head;
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
