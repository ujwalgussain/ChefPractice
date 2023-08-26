package a_practiceproblems.ArrayProblems.binarySearch;

import java.util.List;

public class MedianOfTwoSortedArrays {
    //Link : https://www.interviewbit.com/problems/median-of-array/ ****
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if (a.size() > b.size())
            return findMedianSortedArrays(b, a);
        int x = a.size();
        int y = b.size();
        int lo = 0;
        int hi = x;
        while (lo <= hi) {
            int partitionX = (lo + hi) / 2;
            int partitionY = ((x + y + 1) / 2) - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : a.get(partitionX - 1);
            int minRightX = partitionX == x ? Integer.MAX_VALUE : a.get(partitionX);

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : b.get(partitionY - 1);
            int minRightY = partitionY == y ? Integer.MAX_VALUE : b.get(partitionY);

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if (((x + y) & 1) == 0)
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                else
                    return Math.max(maxLeftX, maxLeftY);
            } else {
                if (maxLeftX > minRightY)
                    hi = partitionX - 1;
                else
                    lo = partitionX + 1;
            }
        }
        return 0.0;
    }
}
