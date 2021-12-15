package a_practiceproblems.linkedlistproblems.Problems;

import a_practiceproblems.linkedlistproblems.LLNode;

public class DetectLoopInLinkedList {
    public static boolean detectLoopInLinkedList(LLNode head)
    {
        /*
         * Approach 1: Visit each Node and put in hashset. While traversing check whether Node is already visited
         * Approach 2: Use Floyd's cycle detection algorithm*/
        LLNode fast_p=head,slow_p=head;
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
