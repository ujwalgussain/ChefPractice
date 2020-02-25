package MonkAndCursedTree;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.util.LinkedList;
import java.util.Scanner;

/*class TestClass {
    class Tree{
        class Node{
            int data;
            Node left,right;
            Node(int d)
            {
                data=d;
            }
        }
        Node root;
        void insert(int d)
        {
            Node n = new Node(d);
            if(root==null)
            {
                root=n;
            }
            else
            {
                Node x=root,y=null;
                while(x!=null)
                {
                    y=x;
                    x=d>x.data?x.right:x.left;
                }
                if(d>y.data)
                {
                    y.right=n;
                }
                else
                {
                   y.left=n;
                }
            }
        }
        void display_LOT()
        {
            if(root == null)
                System.out.println("Tree Empty");
            LinkedList<Node> l = new LinkedList<>();
            l.add(root);
            //System.out.println("Tree Data with Nodes "+ count);
            System.out.printf("Tree ");
            while(!l.isEmpty())
            {
                Node temp = l.removeFirst();
                if(temp==null){
                    System.out.print("null ");
                    continue;
                }
                System.out.print(temp.data+" ");
                l.addLast(temp.left);
                l.addLast(temp.right);
            }
            System.out.println();
        }
        int search(Node r,int x)
        {
            if(r==null)
            {
                return 0;
            }
            System.out.println("Search for "+r.data);
            if(r.data==x )
            {
                return x;
            }
            else
            {
                return Math.max(r.data,search(x>r.data?r.right:r.left,x));
            }
        }

    }
    public static void main(String args[] ) throws Exception {
        *//* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        *//*

        // Write your code here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Tree t = new TestClass().new Tree();
        for(int i=0;i<N;i++)
        {
            t.insert(sc.nextInt());
        }
        t.display_LOT();
        System.out.println();
        System.out.println(Math.max(t.search(t.root,6),t.search(t.root,3)));
    }
}*/

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    class Tree{
        class Node{
            int data;
            Node left,right,parent;
            Node(int d)
            {
                data=d;
            }
        }
        Node root;
        void insert(int d)
        {
            Node n = new Node(d);
            if(root==null)
            {
                root=n;
            }
            else
            {
                Node x=root,y=null;
                while(x!=null)
                {
                    y=x;
                    if(x.data==d)
                        return;
                    x=d>x.data?x.right:x.left;
                }
                if(d>y.data)
                {
                    y.right=n;
                }
                else
                {
                    y.left=n;
                }
                n.parent=y;
            }
        }
        //TreeSet<Integer> set= new TreeSet<>();
        void search(Node r,int x,LinkedList<Integer> set)
        {
            if(r==null)
            {
                return;
            }
            set.add(r.data);
            if(r.data==x)
            {
                return;
            }
            else
            {
                search(x>r.data?r.right:r.left,x,set);
            }
        }
    }
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Tree t = new TestClass().new Tree();
        for(int i=0;i<N;i++)
        {
            t.insert(sc.nextInt());
        }
        int A = sc.nextInt();
        int B = sc.nextInt();
        LinkedList<Integer> list1= new LinkedList<>();
        LinkedList<Integer> list2= new LinkedList<>();
        t.search(t.root,A,list1);
        t.search(t.root,B,list2);
        /*for(int i=1;i<l1.size();i++)
        {
            int x =l1.get(i),y=l2.get(i);
            if(x!=y)
                break;
            else
            {
                l1.remove(i-1);
                l2.remove(i-1);
            }
        }
        System.out.println(l1+" "+l2);*/
        for(int i=1;i<list1.size();i++)
        {
            if(list1.get(i)==list2.get(i))
            {
                list1.remove(i-1);
                list2.remove(i-1);
            }
            else
            {
                break;
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i:list1)
        {
            max=Math.max(i,max);
        }
        for(int i:list2)
        {
            max=Math.max(i,max);
        }
        System.out.println(max);
    }
}


