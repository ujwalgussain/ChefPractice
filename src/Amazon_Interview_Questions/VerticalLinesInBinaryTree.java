package Amazon_Interview_Questions;

import a_practiceproblems.TreeProblems.BSTProblems.BinarySearchTree;
import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VerticalLinesInBinaryTree {
    static void printVerticalLinesUtil(TreeNode root, HashMap<Integer, List<Integer>> map, int level)
    {
        if(root==null)
        {
            return;
        }
        if(map.containsKey(level))
            map.get(level).add(root.getVal());
        else
        {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.getVal());
            map.put(level,list);
        }
        printVerticalLinesUtil(root.getLeft(),map,level-1);

        printVerticalLinesUtil(root.getRight(),map,level+1);
    }
    static void printVerticalLines(TreeNode root)
    {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        printVerticalLinesUtil(root,map,0);
        System.out.println(map);
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertAll(5,2,8,1,4,6,9);
        printVerticalLines(bst.getRoot());
    }
}
