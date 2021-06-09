package ChefProblems.B_Sequence;
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
            int data,count;
            Node left,right,parent;
            char color;
            Node(int d)
            {
                data=d;
                count=1;
                color='R';
            }
        }
        int size=0;
        Node root;int max;
        void left_rotate(Node x)
        {
            Node y=x.right;
            x.right=y.left;
            if(y.left!=null)
            {
                y.left.parent=x;
            }
            y.parent=x.parent;
            if(x==root)
                root=y;
            else if(x==x.parent.left)
                x.parent.left=y;
            else
                x.parent.right=y;
            y.left=x;
            x.parent=y;

        }
        void right_rotate(Node x)
        {
            Node y=x.left;
            x.left=y.right;
            if(y.right!=null)
            {
                y.right.parent=x;
            }
            y.parent=x.parent;
            if(x==root)
                root=y;
            else if(x==x.parent.left)
                x.parent.left=y;
            else
                x.parent.right=y;
            y.right=x;
            x.parent=y;

        }
        void fixUp(Node z)
        {
            while(z.parent!=null && z.parent.color=='R')
            {
                System.out.printf("Z=%d|%s\n",z.data,z.color);
                if(z.parent==z.parent.parent.left)
                {
                    Node y = z.parent.parent.right;
                    if(y!=null && y.color=='R')
                    {
                        y.color='B';
                        z.parent.color='B';
                        z.parent.parent.color = 'R';
                        z=z.parent.parent;
                    }
                    else{
                        if(z == z.parent.right)
                        {
                            z= z.parent;
                            left_rotate(z);
                        }
                        z.parent.color='B';
                        z.parent.parent.color='R';
                        right_rotate(z.parent.parent);
                    }
                }
                else
                {
                    Node y = z.parent.parent.left;
                    if(y!=null && y.color=='R')
                    {
                        y.color='B';
                        z.parent.color='B';
                        z.parent.parent.color = 'R';
                        z=z.parent.parent;
                    }
                    else{
                        if(z == z.parent.left)
                        {
                            z= z.parent;
                            right_rotate(z);
                        }
                        z.parent.color='B';
                        z.parent.parent.color='R';
                        left_rotate(z.parent.parent);
                    }
                }
            }
            root.color='B';
        }
        void insert(int d)
        {
            //System.out.println("Insert "+d);
            if(d == max)
            {
                return;
            }
            Node n = new Node(d);
            if(root==null)
            {
                root=n;
                max=d;
                size++;
            }
            else
            {
                Node x=root,y=null;
                while(x!=null)
                {
                    y=x;
                    if(y.data==d)
                    {
                        if(y.count!=2)
                        {
                            size++;
                        }
                        y.count=2;
                        return;
                    }
                    x=(d>x.data)?x.right:x.left;
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
                size++;
                max = Math.max(max,d);
            }
            fixUp(n);
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
                System.out.print(temp.data+"|"+temp.color+" ");
                l.addLast(temp.left);
                l.addLast(temp.right);
            }
            System.out.println();
        }
        void inOrder(Node r,Stack<Integer> s)
        {
            if(r==null)
                return;
            inOrder(r.left,s);
            System.out.printf("%d ",r.data);
            if(r.count==2)
                s.push(r.data);
            inOrder(r.right,s);
        }
        void display()
        {
            Stack<Integer> s = new Stack();
            inOrder(root,s);
            while(!s.isEmpty())
            {
                System.out.printf("%d ",s.pop());
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
            System.out.println("After Insert ");
            t.display_LOT();
        }
        int Q=sc.nextInt();
        int arr[] = new int[Q];
        for(int i=0;i<Q;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<Q;i++)
        {
            System.out.println("Insert " + arr[i]);
            t.insert(arr[i]);
            System.out.println(t.size);
        }
        t.display();
    }

}
