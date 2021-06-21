package LinkedListTest.Problems;

import LinkedListTest.LLNode;
import LinkedListTest.LinkedList;
import LinkedListTest.LinkedListUtils;

public class LengthOfLoop {
    static int getLengthOfLoopInLinkedList(LinkedList loopedLinkedList) {
        //LinkedList l = LinkedListUtils.LOOPED;
        LLNode fastptr = loopedLinkedList.head, slowptr = loopedLinkedList.head;
        while (fastptr != null && fastptr.next != null) {
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if (slowptr == fastptr) {
                slowptr = slowptr.next;
                int count = 1;
                while (slowptr != fastptr) {
                    slowptr = slowptr.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }
}
