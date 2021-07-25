package a_practiceproblems.linkedlistproblems.Problems;

import a_practiceproblems.linkedlistproblems.LLNode;
import a_practiceproblems.linkedlistproblems.LinkedList;

import java.util.Stack;

public class FindIfLinkedListIsPalindrome {
    static boolean isPalindrome(LinkedList palindromicLinkedList)
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


}
