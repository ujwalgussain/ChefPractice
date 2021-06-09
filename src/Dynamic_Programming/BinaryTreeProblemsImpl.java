package Dynamic_Programming;

import java.util.LinkedList;

public class BinaryTreeProblemsImpl {
    class Node{
        int data;
        Node left, right;
        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    Node root;
    void insertLOT(int data)
    {
        Node n = new Node(data);
        if(root == null)
            root = n;
        else
        {
            LinkedList<Node> q= new LinkedList<>();
            q.addFirst(root);
            Node temp = null;
            while(!q.isEmpty())
            {
                temp = q.removeFirst();
                if(temp.left == null)
                {
                    temp.left = n;
                    break;
                }
                else
                {
                    q.addLast(temp.left);
                }
                if(temp.right == null){
                    temp.right = n;
                    break;
                }
                else
                {
                    q.addLast(temp.right);
                }
            }
        }
    }
    //Needs improvement
    Node getRightMostNode(Node temp){
        System.out.println("temp " + temp.data);
        if(temp.right!=null)
        {
            System.out.println("Go Right");
            return getRightMostNode(temp.right);
        }

        else
        if (temp.left !=null)
        {
            System.out.println("Go Left");
            return getRightMostNode(temp.left);
        }
        System.out.println("Return " + temp.data);
        return temp;

    }
    void displayLOT()
    {
        if(root == null)
            System.out.println("Tree is Empty");
        else{
            LinkedList<Node> q= new LinkedList<>();
            q.addFirst(root);
            Node temp = null;
            System.out.print("Tree Data ");
            while(!q.isEmpty())
            {
                temp = q.removeFirst();
                System.out.print(temp.data+" ");
                if(temp.left != null)
                {
                    q.addLast(temp.left);
                }
                if(temp.right != null){
                    q.addLast(temp.right);
                }
            }
            System.out.println();
        }
    }
    static int diameter = 0;
    int getDiameter(Node n)
    {
        if(n == null)
            return 0;
        int left = getDiameter(n.left);
        int right = getDiameter(n.right);
        if(left + right > diameter)
            diameter = left+right;
        return Math.max(left,right)+1;
    }

    public  static void main(String args[])
    {
        BinaryTreeProblemsImpl tree = new BinaryTreeProblemsImpl();
        tree.insertLOT(1);
        tree.insertLOT(2);
        tree.insertLOT(3);
        /*tree.insertLOT(4);
        tree.insertLOT(5);
        tree.insertLOT(6);
        */tree.displayLOT();
        System.out.println(tree.getDiameter(tree.root));
    }

}
