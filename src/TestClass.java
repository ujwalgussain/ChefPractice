
import a_practiceproblems.linkedlistproblems.LinkedList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class TestClass {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0,new ArrayList<>(),0,candidates, target);
        return ans;
    }
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int i, List<Integer> list, int total, int a[], int t)
    {
        if(total == t)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i>=a.length || total>t)
            return;
        if(list.contains(a[i]))
        {
            list.add(a[i]);
            dfs(i+1,list,total+a[i],a,t);
            list.remove(list.size()-1);
        }
        else
        {
            list.add(a[i]);
            dfs(i+1,list,total+a[i],a,t);
            list.remove(list.size()-1);
            dfs(i+1,list,total,a,t);
        }

    }


    public static void main(String[] args) {
        System.out.println(new TestClass().combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
}

