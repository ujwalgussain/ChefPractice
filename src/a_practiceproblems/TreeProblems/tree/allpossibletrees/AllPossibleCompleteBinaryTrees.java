package a_practiceproblems.TreeProblems.tree.allpossibletrees;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleCompleteBinaryTrees {
    //https://leetcode.com/problems/all-possible-full-binary-trees/submissions/

    /*
    If n is odd only then we can have complete binary trees

    */
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n==0)
            return result;
        else if(n==1)
            result.add(new TreeNode(0));
        else{
            for (int i = 1; i <n; i++) {
                List<TreeNode> leftSubtrees = allPossibleFBT(i);
                List<TreeNode> rightSubTrees = allPossibleFBT(n-i-1); // 1 for root and i for the nodes covered in left subtree
                for (TreeNode leftSubtree: leftSubtrees) {
                    for (TreeNode rightSubtree: rightSubTrees) {

                        TreeNode root = new TreeNode(0);
                        root.left = leftSubtree;
                        root.right = rightSubtree;
                        result.add(root);

                    }
                }
            }
        }
        return result;
    }
}
