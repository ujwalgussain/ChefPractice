package a_practiceproblems.linkedlistproblems.dll.problems;

import a_practiceproblems.linkedlistproblems.dll.DLLNode;

public class GetMiddleOfDLL {
    public static DLLNode get(DLLNode head)
    {
        DLLNode fast = head, slow=head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
