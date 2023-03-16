package a_practiceproblems.TreeProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.LinkedList;

public class CountNodesInTree {
    public static int count(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList();
        list.add(root);
        int c = 0;
        while (!list.isEmpty()) {
           TreeNode node = list.pollFirst();
           c++;
            if (node.left != null)
                list.add(node.left);
            if (node.right != null)
                list.add(node.right);


        }
        return c;
    }
}
