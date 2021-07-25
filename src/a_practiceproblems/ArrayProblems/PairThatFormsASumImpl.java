package a_practiceproblems.ArrayProblems;

import java.util.HashMap;

public class PairThatFormsASumImpl {
    public static void findPairSortedApproach(int arr[], int given_sum)
    {
        int i=arr.length-1,j=0;
        while(i>=0&&j<arr.length)
        {
            //System.out.println(i+" " + j);
            int sum = arr[i]+arr[j];
           // System.out.println("Sum " + sum);
            if(sum==given_sum)
            {
               System.out.println(String.format("Found %s,%s",arr[i],arr[j]));
                i--;
            }
            else
            {
                if(sum>given_sum)
                {
                    i--;
                }
                else{
                    j++;
                }
            }
        }

    }
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> map = new HashMap<>();//FOR ARRAY WITH NON DISTINCT ELEMENTS USE MAP<INTEGER,LIST<INTEGER>>
            for(int i =0;i<nums.length;i++)
            {
                map.put(nums[i],i);
            }
            for(int i =0;i<nums.length;i++)
            {
                int diff = target - nums[i];
                if(map.containsKey(diff))
                {
                    int idx = map.get(diff);
                    if(idx != i) ////-------VERY IMPORTANT...TGT IS 6 AND NO IS 3 IT MAY HAPPEN IT MATCHES WITH ITSELF
                        return new int[]{i,idx};
                }
            }
            return null;
        }
    }
    /*Link : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    Given an array of integers numbers that is already sorted in non-decreasing order,
    find two numbers such that they add up to a specific target number.
    Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
    The tests are generated such that there is exactly one solution. You may not use the same element twice.
    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.*/
    public int[] twoSum(int[] nums_sortedInDesc, int target) {
        int l=0,r=nums_sortedInDesc.length-1;
        while(l<r)
        {
            int sum = nums_sortedInDesc[l]+nums_sortedInDesc[r];
            if(target == sum)
                return new int[]{l+1,r+1};
            if(target < sum)
                r--;
            else
                l++;
        }
        return null;
    }

    public static void main(String args[])
    {
        findPairSortedApproach(new int[]{1,2,3,4,5},6);
    }
}
