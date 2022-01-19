package a_practiceproblems.TreeProblems.BSTProblems;

import java.util.ArrayList;
import java.util.List;

public class FindPostOrderTraversalFromPreOrderBST {
    int preIdx = 0;

    void printPostOrder(ArrayList<Integer> preOrder, int lo, int hi) {
        if (preIdx == preOrder.size() || preOrder.get(preIdx) < lo || preOrder.get(preIdx) > hi) {
            return;
        }
        int val = preOrder.get(preIdx++);
        printPostOrder(preOrder, lo, val - 1);
        printPostOrder(preOrder, val + 1, hi);
        System.out.print(val + " ");
    }

    public static void main(String[] args) {
        new FindPostOrderTraversalFromPreOrderBST()
                .printPostOrder(
                        new ArrayList<>(List.of(40, 30, 35, 80, 100)),
                        Integer.MIN_VALUE,
                        Integer.MAX_VALUE);
    }
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }

    /* Class to print Level Order Traversal */
    /*class BinaryTree {

        Node root;

        // A utility function to do preorder traversal of BST
        void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.data + " "    );
                preOrder(node.left);
                preOrder(node.right);
            }
        }



        public static void main(String args[]) {
            int in[] = {4, 5, 7};
            int n = in.length;
            BinaryTree tree = new BinaryTree();
            ArrayList<Node> trees = tree.getTrees(in, 0, n - 1);
            System.out.println("Preorder traversal of different "+
                    " binary trees are:");
            for (int i = 0; i < trees.size(); i++) {
                tree.preOrder(trees.get(i));
                System.out.println("");
            }
        }
    }*/
}
