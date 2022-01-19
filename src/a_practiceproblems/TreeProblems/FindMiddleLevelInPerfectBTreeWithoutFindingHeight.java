package a_practiceproblems.TreeProblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class FindMiddleLevelInPerfectBTreeWithoutFindingHeight {
    ArrayList<Integer> findMiddleLevel(TreeNode A) {
        //We are using queue is
        TreeNode fast = A;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        //We dont need to check queue is Empty as tree is perfect binaryTree
        while (fast != null && fast.left != null) {
            fast = fast.left.left;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

        }
        return queue.stream().map(x -> x.val).collect(Collectors.toCollection(ArrayList::new));
    }
}
