package a_practiceproblems.ArrayProblems.triplets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsThatFormASum {
    public static void findTripletsWithSum(int A[], int k) {
        Arrays.sort(A);
        int i,j;
        int sum=0;
        int count=0;
        for(int ptr =0; ptr<A.length-2;ptr++)
        {
            i=ptr+1;
            j=A.length-1;
            while(i<j)
            {
                sum = A[ptr] + A[i] + A[j];
                if(sum==k){
                    System.out.println(String.format("%s,%s,%s",A[ptr],A[i],A[j]));
                    count++;
                }
                if(sum>k)
                    j--;
                else
                    i++;
            }
        }
        System.out.println(count);
    }
    //Needs some improvement
    public static void findTripletsWithSumInRange(int A[], int a, int b) {
        Arrays.sort(A);
        int i,j;
        int sum=0;
        int count=0;
        for(int ptr =0; ptr<A.length-2;ptr++)
        {
            i=ptr+1;
            j=A.length-1;
            while(i<j)
            {
                sum = A[ptr] + A[i] + A[j];
                if(sum>a && sum<b){
                    // System.out.println(i+" "+j + " " + ptr);
                   count++;
                }
                if(sum>=b)
                    j--;
                else
                    i++;
            }
        }
        System.out.println(count);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        /* Link : https://leetcode.com/problems/3sum/
        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
        Notice that the solution set must not contain duplicate triplets.*/
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            //Once Sorted, we will know if number is repeated then skip since we have already processed the array for that element earlier
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int ans = nums[i] + nums[l] + nums[r];
                if (ans == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else {
                    if (ans > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return list;
    }

    static public void main(String ars[]) {
        findTripletsWithSum(new int[]{1, 2, 3, 4, 5, 6}, 7);
        findTripletsWithSumInRange(new int[]{1, 2, 3, 4, 5, 6}, 5,9);
    }
}
