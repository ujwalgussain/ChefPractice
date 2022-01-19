package a_practiceproblems.TreeProblems.traversalproblems.constructtree;

import a_practiceproblems.TreeProblems.traversalproblems.traversal.Traversal;
import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConstructTreeUsingInOrderAndLevelOrder {
    public TreeNode create(ArrayList<Integer> inOrder, ArrayList<Integer> levelOrder){
        return util(inOrder,levelOrder,0,levelOrder.size()-1);
    }
    public TreeNode util(ArrayList<Integer> inOrder, ArrayList<Integer> levelOrder, int inStart, int inEnd){
        if(inStart>inEnd)
            return null;
        if(inStart == inEnd)
            return new TreeNode(inOrder.get(inStart));
        int inIdx = -1;
        out : for (int i = 0; i < levelOrder.size(); i++) {
            for (int j = inStart; j <= inEnd; j++) {
                if(levelOrder.get(i)==inOrder.get(j))
                {
                    inIdx = j;
                    break out;
                }
            }
        }
        TreeNode root = new TreeNode(inOrder.get(inIdx));
        root.setLeft(util(inOrder,levelOrder,inStart,inIdx-1));
        root.setRight(util(inOrder,levelOrder,inIdx+1,inEnd));
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new ConstructTreeUsingInOrderAndLevelOrder().create(
                new ArrayList<>(List.of(4, 8, 10, 12, 14, 20, 22)),
                new ArrayList<>(List.of(20, 8, 22, 4, 12, 10, 14))
        );
        Traversal.INORDER.print(root);

    }
}
