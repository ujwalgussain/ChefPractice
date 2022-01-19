package a_practiceproblems.backtracking;

import java.util.*;

public class GeneratePermutation {
    /*
    Links:
        https://leetcode.com/problems/permutations-ii/submissions/
        https://www.youtube.com/watch?v=A3ge2mdQi4g Amell Peralta
     */

    //APPROACH 1:
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permute(nums,new ArrayList<>(),new boolean[nums.length]);
        return new ArrayList<>(set);
    }
    ArrayList<List<Integer>> set = new ArrayList<>();
    public void permute(int[] nums,List<Integer> permutation, boolean used[]){
        if(permutation.size()==nums.length)
            set.add(new ArrayList<>(permutation));
        else{
            for (int i = 0; i < nums.length; i++) {
                if(used[i])
                    continue;
                permutation.add(nums[i]);
                used[i]=true;
                permute(nums,permutation,used);
                permutation.remove(permutation.size()-1);
                used[i]=false;
                //This will ensure that we have unique permutation
                while(i<nums.length-1 && nums[i]==nums[i+1])
                    i++;
            }
        }
    }
}
