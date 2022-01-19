package a_practiceproblems.TreeProblems.tree;

import com.sun.source.tree.Tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public TreeNode() {}
    public TreeNode(int data)
    {
        this.val =data;
    }

    public static TreeNode of(int val) {
        return new TreeNode(val);
    }
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
