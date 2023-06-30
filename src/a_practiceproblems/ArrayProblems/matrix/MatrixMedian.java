package a_practiceproblems.ArrayProblems.matrix;

import java.util.ArrayList;
import java.util.List;

public class MatrixMedian {
    /*
    * The idea for the solution is to use binary search.
    Since there is a condition that each row is sorted but it also means that a column won't be sorted
    Median is a element which is present in the mid of the array if we flatten the array in a sorted manner(since rows  X cols is always odd),
    So we need to count for every element how many elems are lesser than it
    * Ex :
     1 3 5
     2 6 9
     3 6 9
     * Median = 4
     lo = 1 hi =9 Mid = 5 less = 4
     lo = 6 hi =9 Mid = 7 less = 7
     lo = 6 hi =6 Mid = 6 less = 5
     Ans is 5
     */
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            min = Math.min(min, A.get(i).get(0));
            max = Math.max(max, A.get(i).get(n-1));
        }
        int median = (m*n)/2;
        int lo = min, hi = max;
        int ans = -1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int noOfElemsLesserThanMid = getElementsLessThanTarget(A,m,n,mid);
            //System.out.println("Mid = " + mid + " less = " + noOfElemsLesserThanMid + "Median = " + median);
            if(noOfElemsLesserThanMid<=median){
                ans = mid;
                lo = mid+1;
            } else {
                hi = mid -1;
            }
        }
        return ans;
    }

    int getElementsLessThanTarget(ArrayList<ArrayList<Integer>> A, int m, int n, int target) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> curr = A.get(i);
            if(curr.get(n-1)<target) {
                count += n;
            } else {
                if(curr.get(0)<target) {
                    int lo = 0;
                    int hi = n-1;
                    int ans = 0;
                    while (lo <= hi){
                        int mid = (lo + hi) /2;
                        //stop at last element smaller than target
                        if(curr.get(mid)<target) {
                            lo = mid + 1;
                            ans = mid;
                        } else {
                            hi = mid-1;
                        }
                    }
                    count+=ans+1;
                }
            }
        }
        return count;
    }
}

