package a_practiceproblems.TreeProblems;

import com.sun.source.tree.Tree;

import java.util.*;

public class KthSmallestElementInTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y)->y-x);
    public int kthsmallest(TreeNode A, int B) {
        find(A,B);
        return maxHeap.poll();
    }
    void find(TreeNode root, int B){
        if(root==null)
            return;
        if(maxHeap.size()<B) {
            maxHeap.offer(root.val);
        }
        else{
            if(root.val<maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(root.val);
            }
        }
        find(root.left,B);
        find(root.right,B);
    }

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
    }
}
