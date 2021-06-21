package LinkedListTest.Problems.ReversingLL;

import LinkedListTest.LLNode;
import LinkedListTest.LinkedList;
import LinkedListTest.LinkedListUtils;

public class ReverseInGroupsOfK {

    public static LLNode reverseInGroupsOfK(LLNode head, int k)
    {

        //For k = 3 after 1st group reversal
        //head            prev     curr
        //  1       2       3       4  ...

        if(head != null)
        {
            int c = k;
            LLNode next = null, prev = null, current = head;
            while(--c>=0 && current !=null)
            {
                //This reverses 2 nodes
                next = current.next;
                current.next = prev;
                prev=current;
                current = next;
            }
            if(next != null)
                head.next = reverseInGroupsOfK(next,k); //old head will be last element of group after reversal

            return prev; // this is the new head ie., 3

        }
        return null;
    }
    static void printFromHead(LLNode head)
    {
        while(head!=null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }
    public static void main(String[] args) {
        LinkedList l = LinkedListUtils.NORMAL.buildAndReturn();
        printFromHead(reverseInGroupsOfK(l.head,3));
    }
}
