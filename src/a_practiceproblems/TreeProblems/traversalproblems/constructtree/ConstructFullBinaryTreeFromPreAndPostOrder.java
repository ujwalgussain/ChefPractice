package a_practiceproblems.TreeProblems.traversalproblems.constructtree;

import a_practiceproblems.TreeProblems.traversalproblems.traversal.Traversal;
import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConstructFullBinaryTreeFromPreAndPostOrder {
    int preIdx = 0;
    TreeNode construct(ArrayList<Integer> preOrder, ArrayList<Integer> postOrder, int postStart, int postEnd){
        if(preIdx>=preOrder.size() || postStart>postEnd)
            return null;
        TreeNode node = TreeNode.of(preOrder.get(preIdx++));
        if(postStart== postEnd || preIdx>=preOrder.size())
            return node;
        int postIdx;
        for (postIdx = postStart; postIdx <= postEnd; postIdx++) {
            if(postOrder.get(postIdx)==preOrder.get(preIdx)) {
                postIdx = postIdx;
                break;
            }
        }
        //postIdx gives left child of current
        //hence postStart to postIdx contains elements of left subtree in postOrder
        //hence postIdx+1 to postEnd-1 contains elements of right subtree in postOrder
        if(postIdx <= postEnd) {
            node.left = construct(preOrder, postOrder, postStart, postIdx);
            //hi is the node created in the current iteration hence exclude it
            node.right = construct(preOrder, postOrder, postIdx + 1, postEnd - 1);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new ConstructFullBinaryTreeFromPreAndPostOrder().construct(
                new ArrayList<>(List.of(1, 2, 4, 8, 9, 5, 3, 6, 7 )),
                new ArrayList<>(List.of(8, 9, 4, 5, 2, 6, 7, 3, 1)),0,8);
        Traversal.INORDER.print(root);
    }
}
