package a_practiceproblems.linkedlistproblems.Problems.ReversingLL;

import a_practiceproblems.linkedlistproblems.LLNode;

public class ReverseAlternateKNodes {
    public LLNode solve(LLNode A, int B) {
        return reverse(A,B,true);
    }
    public LLNode reverse(LLNode A, int B, boolean reverse){
        if(A==null)
            return A;
        LLNode prev = null;
        LLNode curr = A;
        LLNode next = null;
        int cnt = 0;
        if(reverse){
            while (curr!=null && ++cnt<=B){
                next = curr.next;
                curr.next = prev;
                prev=curr;
                curr = next;
            }
            A.next = reverse(curr,B,!reverse);//new tail
            return prev;//new head
        }
        else{
            while (curr!=null && ++cnt<B) {
                curr=curr.next;
            }
            curr.next = reverse(curr.next,B,!reverse);
            return A;
        }
    }
}
