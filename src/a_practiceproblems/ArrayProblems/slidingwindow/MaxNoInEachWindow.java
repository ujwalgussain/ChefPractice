package a_practiceproblems.ArrayProblems.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxNoInEachWindow {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    /* While moving forward new element is added and 1st element from window is removed
    for each ele in A
        remove all smaller eles from Q end.
        add ele to Q.
        if i>=B-1
            add front Element of Q to result.
            if frontElement of Q is start of this window...then remove

    */
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            int curr = A.get(i);
            while (!list.isEmpty() && list.peekLast() < curr) {
                list.pollLast();
            }
            list.add(curr);
            if(i>=B-1) { //for every last element of the window
                ans.add(list.peekFirst());
                if(!list.isEmpty() && list.peek().equals(A.get(i-B+1))){
                    list.pollFirst();
                }
            }
        }
        return ans;
    }
}
