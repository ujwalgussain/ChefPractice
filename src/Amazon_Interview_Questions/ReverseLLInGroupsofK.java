package Amazon_Interview_Questions;

import a_practiceproblems.linkedlistproblems.LLNode;

public class ReverseLLInGroupsofK {
    /*Approach:
        Reverse(start,K)
        1. Reverse k elements from Start
        2. As start will become the last element after reversing
            Next of start Element = Reverse(Last,K)
    * */
    public static LLNode reverseList(LLNode A, int B) {
        if(A==null)
            return null;
        LLNode prev = null, next = null;
        LLNode curr = A;
        int cnt = 0;
        while(curr != null && cnt<B) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }
        //curr will point to next sublist start
        //prev will point to the new start of existing sublist
        A.next = reverseList(curr,B);
        return prev;
    }


    public static void main(String[] args) {
        reverseList(LLNode.createList(1,2,3,4,5,6),2);
    }
}
