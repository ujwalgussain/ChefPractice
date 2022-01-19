package a_practiceproblems.TreeProblems.traversalproblems.traversal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DiagonalTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    /*-------------------SOLVE USING LOT--------------------------------------------------*/
    public ArrayList<Integer> solveLOT(TreeNode A) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        if (A == null)
            return new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();
        queue.add(A);
        level.add(0);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int l = level.poll();
            if (map.containsKey(l)) {
                map.get(l).add(curr.val);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr.val);
                map.put(l, list);
            }
            if (curr.left != null) {
                queue.add(curr.left);
                level.add(l+1);
            }
            if (curr.right != null) {
                queue.add(curr.right);
                level.add(l);
            }
        }
        return map.values().stream().flatMap(x->x.stream()).collect(Collectors.toCollection(ArrayList::new));
    }

    /*-------------------SOLVE USING RECURSION--------------------------------------------------*/
    public ArrayList<Integer> solve(TreeNode A){
        util(A,0);
        return map.values().stream().flatMap(x->x.stream()).collect(Collectors.toCollection(ArrayList::new));
    }
    TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
    public void util(TreeNode A, int level){
        if(A==null)
            return;
        if(map.containsKey(level)){
            map.get(level).add(A.val);
        }
        else
        {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(A.val);
            map.put(level,al);
        }
        util(A.left,level-1);
        util(A.right,level);
    }
}
