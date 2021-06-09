package ChefProblems.B_Sequence;

import java.util.*;

public class B_Sequence_Impl{
    class Tree{
        class Node{
            int data,count;
            Node left,right;
            Node(int d)
            {
                data=d;count=1;
            }
        }
        int size=0;
        Node root;
        int max=-1;
        void insert(int d)
        {
            if(max!=-1&&d==max)
                return;
            if(root==null)
            {
                root=new Node(d);
                max =d;
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
                            size++;
                        y.count=2;
                        return;
                    }
                    x=(d>x.data)?x.right:x.left;
                }
                if(d>y.data)
                {
                    y.right=new Node(d);
                }
                else
                {
                    y.left=new Node(d);
                }
                max = Math.max(d,max);
                size++;
            }
        }
        void inOrder(Node r, Stack<Integer> l)
        {
            if(r==null)
                return;
            inOrder(r.left,l);
            System.out.printf("%d ",r.data);
            if(r.count==2) {
                l.push(r.data);
            }
            inOrder(r.right,l);
        }
        void display()
        {
            Stack<Integer> l = new Stack<>();
            System.out.printf("Size=%s [ ",size);
            inOrder(root,l);
            while(!l.isEmpty())
            {
                System.out.printf("%d ",l.pop());
            }
            System.out.println(" ]");
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
        int arr[] = new int[N];
        Tree t = new B_Sequence_Impl().new Tree();
        for(int i=0;i<N;i++)
        {
            t.insert(sc.nextInt());
        }
        int len = sc.nextInt();
        int[] Q = new int[len];
        for(int i=0;i<len;i++)
        {
            Q[i]=sc.nextInt();
        }
        //System.out.println(Arrays.toString(Q));
        for(int i=0;i<len;i++)
        {
            t.insert(Q[i]);
            System.out.println("After inserting "+Q[i]);
            t.display();
        }
    }
}
