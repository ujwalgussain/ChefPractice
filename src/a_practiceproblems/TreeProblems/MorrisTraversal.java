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

    /**
     * Note this can be used to find predecessor and successor for a node.
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
                 ) {
                    pred = pred.right;
                }
                /*
                if curr == target then pred = inorder predecessor
                if pred == target -> then curr = inorderSuccessor
                 */
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    //This was the last node in subtree which has curr. Hence, go to right subtree
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

    /*
    static Vector<Integer> postorderTraversal(TreeNode root)
{
    Vector<Integer> res = new Vector<>();
    TreeNode current = root;

    while (current != null)
    {

        // If right child is null,
        // put the current node data
        // in res. Move to left child.
        if (current.right == null) {
            res.add(current.key);
            current = current.left;
        }
        else {
            TreeNode predecessor = current.right;
            while (predecessor.left != null
                   && predecessor.left != current) {
                predecessor = predecessor.left;
            }

            // If left child doesn't point
            // to this node, then put in res
            // this node and make left
            // child point to this node
            if (predecessor.left == null) {
                res.add(current.key);
                predecessor.left = current;
                current = current.right;
            }

            // If the left child of inorder predecessor
            // already points to this node
            else {
                predecessor.left = null;
                current = current.left;
            }
        }
    }

    // reverse the res
    Collections.reverse(res);
    return res;
}
     */
}
