package TreeLevelRelatedQueries.BSTProblems;

import java.util.LinkedList;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data=data;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
public class BinarySearchTree {
    Node root;
    void insertAll(int ...args)
    {
        for(int i:args)
            insert(i);
    }
    void insert(int d)
    {
        Node n = new Node(d);
        if(root==null)
        {
            root = n;
        }
        else
        {
            Node x = root,y=null;
            while(x!=null)
            {
                y=x;
                if(x.data<d)
                    x=x.right;
                else
                    x=x.left;
            }
            if(y.data<d)
                y.right=n;
            else
                y.left=n;
        }
    }
    void delete(int key)
    {
        delete_Rec(root,key);
    }
    private Node delete_Rec(Node root,int key)
    {
        if(root==null)
            return null;
        if(root.data<key)
        {
            root.right=delete_Rec(root.right,key);
        }
        else {
            if (root.data > key) {
                root.left = delete_Rec(root.left, key);
            }
            else
            {
                if(root.right==null) {
                    return root.left;
                }
                if(root.left==null){
                    return root.right;
                }
                int min=getMinValue(root.right);
                root.data=min;
                root.right=delete_Rec(root.right,min);
            }
        }
        return root;
    }
    int getMinValue(Node root)
    {
        int min=root.data;
        while(root.left!=null)
        {
            min=root.left.data;
            root=root.left;
        }
        return min;
    }
    void display(Travesal travesal)
    {
        switch (travesal)
        {
            case LEVELORDER:
            {
                LinkedList<Node> list=new LinkedList<>();
                list.add(root);
                System.out.print("LOT - ");
                while(!list.isEmpty())
                {
                    Node t = list.pollFirst();
                    System.out.print(t.data+" ");
                    if(t.left!=null)
                        list.add(t.left);
                    if(t.right!=null)
                        list.add(t.right);
                }
                System.out.println();
            }
        }
    }
}
enum Travesal{
    INORDER,PREORDER,POSTORDER,LEVELORDER;
}