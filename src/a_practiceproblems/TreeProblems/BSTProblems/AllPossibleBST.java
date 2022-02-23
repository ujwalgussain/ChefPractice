package a_practiceproblems.TreeProblems.BSTProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;
import a_practiceproblems.TreeProblems.tree.allpossibletrees.AllPossibleTrees;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleBST {
    //https://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
    //https://leetcode.com/problems/unique-binary-search-trees-ii/
    public List<TreeNode> generateTrees(int n) {
        return AllPossibleTrees.constructTree(1,n);
    }

}
