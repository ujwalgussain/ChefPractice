package a_practiceproblems.ArrayProblems.binarySearch.rotatedsortedarray;

public class SearchMinInRotatedSortedArray {
    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    static int findMin(int[] nums) {
        /*
        //Linear Search
        int n = nums.length;
        if(n==1)
            return nums[0];
        //array is not rotated
        if(nums[0]<nums[n-1])
            return nums[0];
        int i = 0;
        while(i<n-1 && nums[i]<nums[i+1]){
            i++;
        }

        return nums[i+1];*/

        /*
        Binary Search :
        Find if mid element is smaller than both its neighbours if it is then its answer;
        If not check where to go?
            left? if right array is sorted i.e. nums[mid] <= nums[high]
            right? if left array is sorted i.e. nums[low] <= nums[mid]
         */
        int n = nums.length;
        if(n==1)
            return nums[0];
        //array is not rotated
        if(nums[0]<nums[n-1])
            return nums[0];
        int lo = 0, hi = n-1;
        while(lo<=hi) {
            int mid = (lo + hi) / 2;
            while(nums[lo]==nums[mid] && nums[mid]==nums[hi]){
                lo++;
                hi--;
            }
            if (nums[mid] <= nums[(mid + 1) % n] //if mid < next sorted elem
                    &&
                    nums[(mid - 1 + n) % n] >= nums[mid]) { //if prev sorted elem is greater than mid
                return nums[mid];
            } else {
                if (nums[mid] < nums[hi]) //mid to hi is already sorted....hence ans will be in unsorted part...
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            System.out.printf("lo-%s hi-%s\n",lo,hi);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {3,3,3,1}));
    }
}
