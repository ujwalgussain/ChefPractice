package a_practiceproblems.ArrayProblems.binarySearch.rotatedsortedarray;

import java.util.Arrays;

public class SearchMaxInRotatedSortedArray {
    //https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/1712819/Binary-Search-oror-Java-oror-Clear-Explanation
    static int findMaxElementIdx(int nums[]){
        int n = nums.length;
        int lo = 0, hi = n-1;
        while (lo<=hi){
            int mid = (lo+hi)/2;
            if(nums[(mid+1)%n]<=nums[mid] //next element is smaller
                    &&
                    nums[(mid-1+n)%n]<=nums[mid]) //prev element is smaller
                return mid;
            else{
                //if left is sorted...max will lie in other side
                if(nums[lo]<=nums[mid])
                    lo=mid+1;
                else
                    hi=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(findMaxElementIdx(new int[]{4,5,6,7,0,1,2})); //3
        System.out.println(findMaxElementIdx(new int[]{1,2,3,4,5,6})); //5
        System.out.println(findMaxElementIdx(new int[]{6,5,4,3,2,1})); // 0
        System.out.println(findMaxElementIdx(new int[]{1})); //0
    }
}
