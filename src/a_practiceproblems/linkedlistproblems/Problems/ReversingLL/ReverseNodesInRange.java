package a_practiceproblems.linkedlistproblems.Problems.ReversingLL;

import a_practiceproblems.linkedlistproblems.LLNode;

public class ReverseNodesInRange {

    /*
    Link: https://www.interviewbit.com/problems/reverse-link-list-ii/
    Input:
    1           2           3           4           5           6
    startPrev   start                   end         endNext

    Output:
    1           4           3           2           5           6
    startPrev   end                   start         endNext
    */
    public LLNode reverseBetween(LLNode A, int B, int C) {
        LLNode startPrev = null;
        LLNode temp = A;
        int pos = 1;
        while (temp != null && pos<B) {
            startPrev = temp;
            temp = temp.next;
            pos++;
        }

        LLNode curr = temp;
        LLNode prev = null, next = null;
        while (curr != null && pos<=C) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            pos++;
        }
        LLNode endNext = next;

        temp.next = endNext;
        if(startPrev==null){
            return prev;
        }
        startPrev.next = prev;
        return A;
    }
}
