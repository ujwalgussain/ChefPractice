package LinkedListTest.Problems;

import LinkedListTest.LLNode;
import LinkedListTest.LinkedList;
import LinkedListTest.LinkedListUtils;

public class DetectLoopInLinkedList {
    public static boolean detectLoopInLinkedList(LinkedList l)
    {
        /*
         * Approach 1: Visit each Node and put in hashset. While traversing check whether Node is already visited
         * Approach 2: Use Floyd's cycle detection algorithm*/
        LLNode fast_p=l.head,slow_p=l.head;
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                return true;
            }
        }
        return false;
    }
}
