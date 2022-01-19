package a_practiceproblems.TreeProblems.traversalproblems.traversal;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class IterativePostOrder {
    static ArrayList<Integer> postOrderIterativeWith2Stacks(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {
            TreeNode temp = s1.pop();
            s2.push(temp);
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }
        ArrayList<Integer> postOrder = new ArrayList<>();
        while (!s2.isEmpty())
            postOrder.add(s1.remove(0).val);
        return postOrder;
    }
}
