package a_practiceproblems.TreeProblems;

import a_practiceproblems.TreeProblems.BSTProblems.BinarySearchTree;
import a_practiceproblems.TreeProblems.tree.TreeNode;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;

public class PrintingViewsImpl {
    enum View{LEFT,RIGHT,TOP,BOTTOM};
    static BinarySearchTree bst;
    static int maxLevel=0;
    static void printLeftViewRec(TreeNode n, int level)
    {
        if(n==null)
            return;
        if(level>maxLevel) {
            System.out.print(n.val + " ");
            maxLevel=level;
        }
        printLeftViewRec(n.left,level+1);
        printLeftViewRec(n.right,level+1);
    }
    static void printRightViewRec(TreeNode n, int level)
    {
        if(n==null)
            return;
        if(level>maxLevel) {
            System.out.print(n.val + " ");
            maxLevel=level;
        }
        printRightViewRec(n.right,level+1);
        printRightViewRec(n.left,level+1);
    }
    static void printTopView()
    {
        LinkedList<Pair<Integer, TreeNode>> q = new LinkedList<>();
        int hd=0;
        q.add(new Pair<>(hd,bst.root));
        HashMap<Integer,Integer> map = new HashMap<>();
        while(!q.isEmpty())
        {
            Pair<Integer, TreeNode> curr = q.poll();
            hd = curr.getKey();
            TreeNode n = curr.getValue();
            if(!map.containsKey(hd))
            {
                map.put(hd,n.val);
                System.out.print(n.val +" ");
            }
            if(n.left!=null)
                q.addLast(new Pair<>(hd-1,n.left));
            if(n.left!=null)
                q.addLast(new Pair<>(hd+1,n.right));
        }
        System.out.println();
    }

    static void printBottomView()
    {
        LinkedList<Pair<Integer, TreeNode>> q = new LinkedList<>();
        int hd=0;
        q.add(new Pair<>(hd,bst.root));
        HashMap<Integer,Integer> map = new HashMap<>();
        while(!q.isEmpty())
        {
            Pair<Integer, TreeNode> curr = q.poll();
            hd = curr.getKey();
            TreeNode n = curr.getValue();
            map.put(hd,n.val);
            if(n.left!=null)
                q.addLast(new Pair<>(hd-1,n.left));
            if(n.left!=null)
                q.addLast(new Pair<>(hd+1,n.right));
        }
        System.out.println(map.values());
    }

    public static void main(String[] args) {
        bst= new BinarySearchTree();
        bst.insertAll(10,5,15,18,16,19,3,7,1,4,14);
        printTopView();
        System.out.println("LEFT VIEW");
        maxLevel=0;
        printLeftViewRec(bst.root,1);
        System.out.println();
        System.out.println("RIGHT VIEW");
        maxLevel=0;
        printRightViewRec(bst.root,1);
        System.out.println();
        System.out.println("BOTTOM VIEW");
        printBottomView();

    }
}
