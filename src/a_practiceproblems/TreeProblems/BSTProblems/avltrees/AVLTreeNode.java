package a_practiceproblems.TreeProblems.BSTProblems.avltrees;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.Optional;
import java.util.function.Function;

public class AVLTreeNode {
    public int data, height;
    public AVLTreeNode left, right, parent;

    public AVLTreeNode(int data) {
        this.data = data;
        this.height = 1;
    }

    public String printNode() {
        return String.format("%s<--%s[height=%s]-->%s",
                Optional.ofNullable(left).map(avlTreeNode -> avlTreeNode.data).orElse(null),
                data, height,
                Optional.ofNullable(right).map(avlTreeNode -> avlTreeNode.data).orElse(null));

    }
}
