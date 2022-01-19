package a_practiceproblems.backtracking.subsetproblems;

import java.util.*;

public class SubsetsWithoutDuplicates {
    //https://leetcode.com/problems/subsets-ii/submissions/

    /*
    Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.
    Input: nums = [1,2,2]
    Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsets.add(new ArrayList<>()); //empty set
        generateSubsets(nums,0,new ArrayList<>());
        return subsets;
    }
    List<List<Integer>> subsets = new ArrayList<>();
    public void generateSubsets(int nums[],int idx, List<Integer> list){
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            //Add subset
            subsets.add(new ArrayList<>(list));

            generateSubsets(nums,i+1,list);

            list.remove(list.size()-1);
            //avoid duplicates
            while(i<nums.length-1 && nums[i]==nums[i+1])
                i++;
        }
    }
}
