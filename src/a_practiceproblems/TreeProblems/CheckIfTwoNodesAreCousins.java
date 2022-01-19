package a_practiceproblems.TreeProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.LinkedList;

public class CheckIfTwoNodesAreCousins {
    //https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
    public boolean isCousins(TreeNode root, int a, int b) {
        LinkedList<TreeNode> list = new LinkedList();
        LinkedList<TreeNode> parentTracker = new LinkedList();
        list.add(root);
        //Used as indicator if node is found
        TreeNode parentA = null;
        TreeNode parentB = null;
        while (!list.isEmpty()) {
            int size = list.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = list.pollFirst();
                TreeNode parent = parentTracker.poll();
                if (node.val == a)
                    parentA = parent;
                if (node.val == b)
                    parentB = parent;
                if (node.left != null) {
                    list.add(node.left);
                    parentTracker.add(node);
                }
                if (node.right != null) {
                    list.add(node.right);
                    parentTracker.add(node);
                }
            }
            //parent of A and B should be different
            if (parentA != null && parentB != null && parentA != parentB)
                return true;
            //If one of the node is found at current level that means other node is in another level
            //Hence not cousin
            if (parentA != null || parentB != null)
                return false;
        }
        return false;
    }


}
