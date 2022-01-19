package a_practiceproblems.backtracking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CombinationSum2 {
    //https://leetcode.com/problems/combination-sum-ii/
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,new LinkedList<>(),target);
        return ans;
    }
    ArrayList<List<Integer>> ans = new ArrayList<>();
    public void dfs(int candidates[], int start, LinkedList<Integer> list, int total)
    {
        if(total==0)
            //add to resultSet
            ans.add(new ArrayList<>(list));
        else{
            if(start==candidates.length || total<0)
                return;
            for (int currIdx = start; currIdx < candidates.length; currIdx++) {
                if(currIdx!=start && candidates[currIdx-1]==candidates[currIdx])
                    continue;
                list.add(candidates[currIdx]);
                dfs(candidates,currIdx+1,list,total-candidates[currIdx]);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{1,1,2,5},
        8));
    }
}
