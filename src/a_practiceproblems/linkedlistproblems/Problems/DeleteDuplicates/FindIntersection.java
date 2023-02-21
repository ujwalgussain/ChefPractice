package a_practiceproblems.linkedlistproblems.Problems.DeleteDuplicates;

import a_practiceproblems.linkedlistproblems.LLNode;

public class FindIntersection {
    //Not tested yet
    public static LLNode findIntersection(LLNode head1, LLNode head2)
    {
        // code here.
        LLNode t1 = head1, t2 = head2, intHead, intTail;
        while (t1 != null && t2 != null) {
            while (t1 != null && t2 != null && t1.data < t2.data) {
                t1 = t1.next;
            }
            while (t1 != null && t2 != null && t1.data > t2.data) {
                t2 = t2.next;
            }
            if (t1 != null && t2 != null && t1.data == t2.data) {
                if(t1.next == null)
                    return t1;
                if(t2.next == null)
                    return t2;
                LLNode start = t1, end = null;
                while (t1 != null && t2 != null && t1.data == t2.data) {
                    end = t1;
                    t1 = t1.next;
                }
                end.next = null;
                return start;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        findIntersection(LLNode.createList(2,5,8,12), LLNode.createList(12));
    }
}
