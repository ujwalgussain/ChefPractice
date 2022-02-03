package a_practiceproblems.linkedlistproblems;

import a_practiceproblems.TestClass3;

public class ReorderList {
    public void reorderList(ListNode head) {
        //https://leetcode.com/problems/reorder-list/
        /*
        1) Find the middle point using tortoise and hare method.
        2) Split the linked list into two halves using found middle point in step 1.
        3) Reverse the second half.
        4) Do alternate merge of first and second halves.
        */
        if (head==null || head.next==null || head.next.next==null)
            return;
        //Find middle
        ListNode fast = head,slow=head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = slow.next;
        slow.next=null;
        ListNode temp = head;
        ListNode temp2 = reverse(secondHalf);
        ListNode next1 = null,next2=null;
        while (temp!=null){
            next1 = temp.next;
            next2 = temp2.next;
            temp.next = temp2;
            temp2.next = next1;
            temp = next1;
            temp2=next2;
        }
    }
    ListNode reverse(ListNode head){
        ListNode temp1 = head;
        ListNode prev = null, next = null;
        while (temp1!=null){
            next = temp1.next;
            temp1.next=prev;
            prev=temp1;
            temp1=next;
        }
        return prev;
    }
}
