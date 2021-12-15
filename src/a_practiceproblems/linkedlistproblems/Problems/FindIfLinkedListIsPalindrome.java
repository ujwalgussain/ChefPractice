package a_practiceproblems.linkedlistproblems.Problems;

import a_practiceproblems.linkedlistproblems.LLNode;

import java.util.Stack;

public class FindIfLinkedListIsPalindrome {
    static boolean isPalindromeWithStack(LLNode head)
    {
        //Approach 1: Put all the data of Linked List in the Stack. Traverse the list again and pop element if matched

       // LinkedListUtils.buildPalindromicLinkedList();
        Stack<Integer> stack = new Stack<>();
        LLNode temp = head;
        while(temp!=null) {
            stack.push(temp.data);
            temp=temp.next;
        }

        temp = head;
        while(temp!=null) {
            if(temp.data!=stack.pop())
                return false;
            temp=temp.next;
        }
        return true;
    }


    //Second Way : reverse list from the middle node of the stack. and then compare.
    //Note : Even- fast stops at null and Odd - fast stops at last element
    static boolean lPalin(LLNode A) {
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
                return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private static LLNode reverse(LLNode head) {
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
}
