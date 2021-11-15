package a_practiceproblems.linkedlistproblems.Problems;

import a_practiceproblems.linkedlistproblems.LLNode;
import a_practiceproblems.linkedlistproblems.LinkedList;

import java.util.Stack;

public class FindIfLinkedListIsPalindrome {
    static boolean isPalindromeWithStack(LinkedList palindromicLinkedList)
    {
        /*Approach 1: Put all the data of Linked List in the Stack. Traverse the list again and pop element if matched
        Approach 2:
        * */
       // LinkedListUtils.buildPalindromicLinkedList();
        LLNode fastptr=palindromicLinkedList.head,mid=palindromicLinkedList.head;
        Stack<Integer> stack = new Stack<>();
        while(fastptr!=null && fastptr.next !=null)
        {
            fastptr=fastptr.next.next;
            mid=mid.next;
        }
        LLNode temp=mid;
        while(temp!=null)
        {
            stack.push(temp.data);
            temp=temp.next;
        }
        temp=palindromicLinkedList.head;
        while(temp!=mid)
        {
            if(stack.peek() != temp.data)
                return false;
            stack.pop();
            temp=temp.next;

        }
        if(stack.size()>1)
            return false;
        return true;
    }


    //Second Way
    public LLNode reverse(LLNode head) {
        LLNode prev = null;
        LLNode curr = head;
        LLNode next = null;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public int lPalin(LLNode A) {
        LLNode fast = A, slow =A;

        //Even- fast stops at null
        //Odd - fast stops at last element
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        LLNode secondHalf = slow;

        if(fast != null){
            secondHalf = slow.next;
        }

        secondHalf = reverse(secondHalf);

        LLNode firstHalf = A;
        while (secondHalf != null) {
            if(firstHalf.data != secondHalf.data)
                return 0;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return 1;
    }


}
