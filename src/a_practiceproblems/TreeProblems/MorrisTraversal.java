package a_practiceproblems.TreeProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.ArrayList;

public class MorrisTraversal {
    /*
    current = root
    while(current != null)
        if current doesnt have left     [Left skewed tree or leaf node]
            visit current
            current = current.right
        else
            pred = find pred(curr)
            if(pred doesnt have right) [Means that the predecessor is not visited]
                pred.right = current
                current = current.left
            else
                pred.right = null [Means that the predecessor is already visited and we came here twice, which means all nodes are visited in the left subtree, hence go right]
                visit(current)
                current = current.right
    */
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        TreeNode curr = A;
        ArrayList<Integer> inorder = new ArrayList<>();
        while (curr != null) {
            if (curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null &&
                        pred.right != curr  //important
                 )
                    pred = pred.right;
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        TreeNode curr = A;
        ArrayList<Integer> preOrder = new ArrayList<>();
        while (curr != null) {
            if (curr.left == null) {
                preOrder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null &&
                        pred.right != curr  //important
                )
                    pred = pred.right;
                if (pred.right == null) {
                    preOrder.add(curr.val);
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
        return preOrder;
    }
}
