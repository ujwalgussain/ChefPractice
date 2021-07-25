package a_practiceproblems.ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsThatFormASum {
    public static void findTriplets(int arr[], int given_sum)
    {
        int pivot=0, i=pivot+1, j=arr.length-1;
        while(pivot!=arr.length-2)
        {
            if(i==j)
            {
                pivot++;
                i=pivot+1;
                j=arr.length-1;

            }
            int sum = arr[pivot]+ arr[i]+arr[j];
            if(sum ==given_sum){
                System.out.println(String.format("Triplets are %s,%s,%s",arr[pivot],arr[i], arr[j]));
                j--;
            }
            else
            {
                if(sum>given_sum)
                    j--;
                else
                    i++;
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        /* Link : https://leetcode.com/problems/3sum/
        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.*/
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++)
        {
            //Once Sorted, we will know if number is repeated then skip since we have already processed the array for that element earlier
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int l=i+1,r=nums.length-1;
            while(l<r){
                int ans = nums[i]+nums[l]+nums[r];
                if(ans==0)
                {
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;r--;
                }
                else
                {
                    if(ans>0)
                    {
                        r--;
                    }
                    else
                    {
                        l++;
                    }
                }
            }
        }
        return list;
    }

    static public void main(String ars[])
    {
        findTriplets(new int[]{1,2,3,4,5,6},10);
    }
}
