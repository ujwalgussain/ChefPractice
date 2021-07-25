package a_practiceproblems.TreeProblems.BSTProblems.avltrees;

import java.util.Optional;

import static a_practiceproblems.TreeProblems.BSTProblems.avltrees.AVLTreeUtils.height;

public class AVLTree {
    public static AVLTreeNode insertAll(int ele1, int... eles) {
        AVLTreeNode root;
        root = insert(null, ele1);
        for (int ele : eles) {
            root = insert(root, ele);
        }
        return root;
    }

    public static int getBalance(AVLTreeNode root) {
        return root == null ? 0 : getHeightOrZero(root.left) - getHeightOrZero(root.right);
    }

    public static AVLTreeNode insert(AVLTreeNode root, int key) {
        if (root == null) {
            return new AVLTreeNode(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
            root.left.parent = root;
        } else {
            root.right = insert(root.right, key);
            root.right.parent = root;
        }

        //update height
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        //Insertion happened in Right Subtree - [-2 or greater]
        if (balance < -1) {
            //Left of Right Subtree
            if (root.right.data > key)
                return Rotations.RIGHTLEFT.rotate(root);
            // Right of Right Subtree
            return Rotations.LEFT.rotate(root);
        }
        //Insertion happened in Left Subtree - [2 or Greater]
        if (balance > 1) {
            //Right of Left Subtree
            if (key > root.left.data)
                return Rotations.LEFTRIGHT.rotate(root);
            //Left of Left Subtree
            return Rotations.RIGHT.rotate(root);
        }
        return root;
    }

    static int getHeightOrZero(AVLTreeNode root) {
        return Optional.ofNullable(root).map(avlTreeNode -> height(avlTreeNode)).orElse(0);
    }

    public static void main(String[] args) {
        /*  //Test singleLeftRotate
        AVLTreeNode n_10 = new AVLTreeNode(10);
        AVLTreeNode n_20 = new AVLTreeNode(20);
        AVLTreeNode n_30 = new AVLTreeNode(30);
        n_20.right = n_30;
        n_10.right = n_20;
        //singleLeftRotate(n_10);
        Rotations.LEFT.rotate(n_10);
        System.out.println(n_10.printNode());
        System.out.println(n_20.printNode());
        System.out.println(n_30.printNode());
*/
        
        /*// Test singleRightRotate
        AVLTreeNode n_10 = new AVLTreeNode(10);
        AVLTreeNode n_9 = new AVLTreeNode(9);
        AVLTreeNode n_8 = new AVLTreeNode(8);
        n_9.left = n_8;
        n_10.left = n_9;
        Rotations.RIGHT.rotate(n_10);
        System.out.println(n_10.printNode());
        System.out.println(n_9.printNode());
        System.out.println(n_8.printNode());*/

        /*  // Test doubleRotateLeftRight

        AVLTreeNode n_10 = new AVLTreeNode(10);
        AVLTreeNode n_5 = new AVLTreeNode(5);
        AVLTreeNode n_8 = new AVLTreeNode(8);
        n_5.right = n_8;
        n_10.left = n_5;
        Rotations.LEFTRIGHT.rotate(n_10);

        System.out.println(n_10.printNode());
        System.out.println(n_5.printNode());
        System.out.println(n_8.printNode());*/

        /*
        //Test RIGHTLEFT
        AVLTreeNode n_10 = new AVLTreeNode(10);
        AVLTreeNode n_20 = new AVLTreeNode(20);
        AVLTreeNode n_15 = new AVLTreeNode(15);
        n_20.left = n_15;
        n_10.right = n_20;
        Rotations.RIGHTLEFT.rotate(n_10);

        System.out.println(n_10.printNode());
        System.out.println(n_20.printNode());
        System.out.println(n_15.printNode());*/

        AVLTreeNode root = insertAll(10, 15, 12);

        System.out.println(root.printNode());
        System.out.println(root.left.printNode());
        System.out.println(root.right.printNode());
    }


}
