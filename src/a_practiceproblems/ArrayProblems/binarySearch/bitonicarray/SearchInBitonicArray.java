package a_practiceproblems.ArrayProblems.binarySearch.bitonicarray;

public class SearchInBitonicArray {
    public static int search(int[] A, int B) {
        int n = A.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (A[mid] == B)
                return mid;

            else if (mid == n - 1 || A[mid] < A[mid + 1]) {
                // we are in the increasing part of the  array
                // we will apply binarySearch as we do in a
                // simple sorted increasing array
                if (A[mid] < B)
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                // the array is decreasing
                if (A[mid] < B)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

}
