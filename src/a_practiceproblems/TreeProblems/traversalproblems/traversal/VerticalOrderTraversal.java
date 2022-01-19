package a_practiceproblems.TreeProblems.traversalproblems.traversal;

import java.util.*;

public class VerticalOrderTraversal {
    //https://www.interviewbit.com/problems/vertical-order-traversal-of-binary-tree/
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

    /*Solution is correct but result not in required order
   public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
       traverse(A,0);
       return new ArrayList<>(map.values());
   }

   TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();

   void traverse(TreeNode root,int level){
       if(root == null)
           return;
       ArrayList<Integer> al = map.get(level);
       if(al==null){
           al = new ArrayList<>();
          map.put(level,al);
       }
       al.add(root.val);
       traverse(root.left,level-1);
       traverse(root.right,level+1);
   }*/
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

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
                level.add(l - 1);
            }
            if (curr.right != null) {
                queue.add(curr.right);
                level.add(l + 1);
            }
        }
        return new ArrayList<>(map.values());
    }



}
