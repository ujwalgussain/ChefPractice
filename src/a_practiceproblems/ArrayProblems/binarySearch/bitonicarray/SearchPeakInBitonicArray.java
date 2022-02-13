package a_practiceproblems.ArrayProblems.binarySearch.bitonicarray;

public class SearchPeakInBitonicArray {
    public static int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            //System.out.printf("lo-%s hi-%s mid-%s\n",l,r,mid);
            //Go Left until we are in non decreasing part
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                //Go right if in asc part
                l = mid + 1;
            }
        }
        return l;
    }

}
