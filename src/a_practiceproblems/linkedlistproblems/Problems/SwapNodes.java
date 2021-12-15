package a_practiceproblems.linkedlistproblems.Problems;

import a_practiceproblems.linkedlistproblems.LLNode;


public class SwapNodes {
    static void swap2Nodes(LLNode head,int x, int y)
    {
        //LinkedList l = LinkedListUtils.NORMAL;
        if(x == y)
            return;
        else
        {
            LLNode temp=head;
            LLNode prev = null,prevX=null,prevY=null;
            LLNode X=null,Y=null;
            while(temp!=null)
            {
                if(temp.data==x)
                {
                    prevX=prev;
                    X=temp;
                    System.out.println("Found X"+X+" Prev-" + prevX);
                }
                if(temp.data==y)
                {
                    prevY=prev;
                    Y=temp;
                    System.out.println("Found Y" +Y +"Prev-" + prevY);
                }
                prev=temp;
                temp=temp.next;
            }
            LLNode nextX=X.next;
            X.next=Y.next;
            if(prevY !=null)
                prevY.next=X;
            Y.next=nextX;
            if(prevX != null)
                prevX.next=Y;
            if(head==X)
                head=Y;
            if(head==Y)
                head=X;
            System.out.println("After Swap "+head);
        }
    }
}
