package a_practiceproblems.TreeProblems.BSTProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleBST {
    //https://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
    //https://leetcode.com/problems/unique-binary-search-trees-ii/
    public List<TreeNode> generateTrees(int n) {
        return constructTree(1,n);
    }
    public List<TreeNode> constructTree(int start, int end){
        ArrayList<TreeNode> list = new ArrayList<>();
        if(start>end)
            list.add(null);
        else{
            for (int i = start; i <= end; i++) {
                //All Possible BST of values less than i
                List<TreeNode> leftSubtree = constructTree(start,i-1);
                //All Possible BST of values greater than i
                List<TreeNode> rightSubtree = constructTree(i+1,end);
                for (TreeNode left: leftSubtree) {
                    for (TreeNode right: rightSubtree){
                        TreeNode root = new TreeNode(i);
                        root.left= left;
                        root.right = right;
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }
}
