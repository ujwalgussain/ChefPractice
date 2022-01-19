package a_practiceproblems.linkedlistproblems;

import a_practiceproblems.TestClass3;

public class ReverseNodesWithinRange {
    //https://leetcode.com/problems/reverse-linked-list-ii/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //We need 2 ptrs one before left and one after right.
        /*
        S1 : Find prev node of leftPosNode
        S2 : Starting from leftPosNode reverse (right-left)+1 nodes
        S3 : Next of leftPosNode[new tail] will be node at rightPos+1Node and leftPos-1Node next will be rightPosNode
         */
        if(left==right)
            return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next=head;
        ListNode temp = dummyHead;
        int pos = 0;
        while (temp!=null){
            if(pos+1==left) //to stop one pos before left
                break;
            pos++;
            temp=temp.next;
        }
        //Reverse
        ListNode leftPrev = temp; //Pointer 1
        ListNode start = leftPrev.next;//After reverse this will be the new tail
        int steps = right-left+1; //No of nodes to be reversed
        //Reverse
        ListNode curr = start;
        ListNode prev = null, next=null;
        while(--steps>=0 && curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        start.next=next; //tail.next should be node at right+1
        leftPrev.next=prev; //new start of the reversed list
        return dummyHead.next;
    }
    public static void main(String[] args) {
        ListNode head = ListNode.createList(1,2,3,4,5);
        ListNode head2 = new ReverseNodesWithinRange().reverseBetween(head,2,4);
    }
}
