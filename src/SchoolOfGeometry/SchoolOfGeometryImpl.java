package SchoolOfGeometry;

import java.util.*;

public class SchoolOfGeometryImpl {

    class BinarySearchTree
    {
        class Node{
            int data;
            Node left, right, parent;
            Node(int data)
            {
                this.data = data;
            }
        }
        Node root;
        void insert(int data)
        {
            Node z = new Node(data);
            if(root == null)
                root = z;
            else
            {
                Node x =root, y = null;
                while(x != null)
                {
                    y = x;
                    x =(z.data<x.data)? x.left:x.right;
                }
                if(z.data < y.data)
                {
                    y.left = z;
                }
                else
                {
                    y.right = z;
                }
                z.parent = y;
                System.out.println("Sucessfully Added");
            }
        }
        void transplant(Node u , Node v)
        {
            if(root == u) {
                root=v;

            }
            else{
                if(u == u.parent.left)
                    u.parent.left = v;
                else
                    u.parent.right = v;
                if(v!=null)
                    v.parent = u.parent;
            }

        }
        Node tree_min(Node z)
        {
            Node res = z.left;
            if(res.left!=null)
            {
                res = res.left;
            }
            return res;
        }
        Node search(int z)
        {
            if(root==null)
            {
                System.out.println("Tree is empty");
                return null;
            }
            else
            {
                Node temp=root;
                while(temp!=null)
                {
                    if(temp.data==z)
                    {
                        System.out.println("Node found");
                        return temp;
                    }
                    temp=z>temp.data?temp.right:temp.left;
                }
                System.out.println("Node not found");
                return null;
            }
        }
        void delete(int z)
        {
            deleteBSTNode(search(z));
        }
        void deleteBSTNode(Node z)
        {
            if(root==null)
            {
                System.out.println("No deletion");
            }
            if(z.left == null)
            {
                transplant(z,z.right);
            }
            else
            {
                if(z.right == null)
                {
                    transplant(z,z.left);
                }
                else
                {
                    Node y = tree_min(z.right);
                    if(z.parent!=y)
                    {
                        transplant(y,y.right);
                        y.right = z.right;
                        y.right.parent = y;
                    }
                    transplant(z,y);
                    y.left = z.left;
                    y.left.parent = y;

                }
            }
        }
        void displayLOT()
        {
            LinkedList<Node> l = new LinkedList<>();
            l.add(root);
            System.out.printf("Tree ");
            while (!l.isEmpty())
            {
                Node temp=l.removeFirst();
                if(temp==null)
                {
                    System.out.printf("null ");
                    continue;
                }
                System.out.printf("%d ",temp.data);
                l.addLast(temp.left);
                l.addLast(temp.right);
            }
            System.out.println();
        }
    }
    public static void BST_approach()
    {
        Scanner sc = new Scanner(System.in);
        int T = 0;
        if(sc.hasNext())
            T= sc.nextInt();
        while(--T>=0)
        {
            int N=0;
            if(sc.hasNext())
                N=sc.nextInt();
            int arr1[]=new int[N];
            for(int i=0;i<N;i++)
            {
                arr1[i]=sc.nextInt();
            }
            BinarySearchTree tree = new SchoolOfGeometryImpl().new BinarySearchTree();
            for(int i=0;i<N;i++)
            {
                tree.insert(sc.nextInt());
            }
            tree.displayLOT();
            tree.delete(4);
            tree.displayLOT();
        }
    }

    public static void main(String args[])
    {
        BF();
    }
    public static void m2()
    {
        Scanner sc = new Scanner(System.in);
        int T = 0;
        if(sc.hasNext())
            T= sc.nextInt();
        while(--T>=0) {
            int N = 0;
            if (sc.hasNext())
                N = sc.nextInt();
            int arr1[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr1[i] = sc.nextInt();
            }
            TreeMap<Integer,Integer> map = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                int ele=sc.nextInt();
                map.put(ele,map.containsKey(ele)?map.get(ele)+1:1);
            }
            int sum=0;
            for (int i = 0; i < N; i++) {
                int curr = arr1[i];
                if(map.containsKey(curr))
                {
                    sum+=curr;
                    int value=map.get(curr);
                    if(value==1)
                    {
                        map.remove(curr);
                    }
                    else
                    {
                        map.put(curr,map.get(curr)-1);
                    }
                }
                else
                {
                    if(map.lowerKey(curr)!=null)
                    {

                        int key = map.lowerKey(curr); sum+=key;
                        int value=map.get(key);
                        if(value==1)
                        {
                            map.remove(key);
                        }
                        else
                        {
                            map.put(key,map.get(key)-1);
                        }
                    }
                    else
                    {
                        sum+=arr1[i];
                    }
                }
            }
            System.out.println(sum);
        }
    }
    void sort_Approach()
    {

    }
    static void BF()
    {
        Scanner sc = new Scanner(System.in);
        int T = 0;
        if(sc.hasNext())
            T= sc.nextInt();
        while(--T>=0) {
            int N = 0;
            if (sc.hasNext())
                N = sc.nextInt();
            int arr1[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr1[i] = sc.nextInt();
            }
            int arr2[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr2[i] = sc.nextInt();
            }
            System.out.println(permute(arr1,arr2,0,N-1));
        }
    }
    static void swap(int arr[], int l, int i)
    {
        int temp=arr[l];
        arr[l]=arr[i];
        arr[i]=temp;
    }
    static int permute(int arr1[],int arr2[], int l, int r)
    {
        // Base case
        if (l == r)
        {
            int sum=0;
            for(int i=0;i<arr1.length;i++)
            {
                sum+=Math.min(arr1[i],arr2[i]);
            }return sum;
        }
        else
        {
            // Permutations made
            int res=0;
            for (int i = l; i <= r; i++)
            {

                // Swapping done
                swap(arr2,l,i);

                // Recursion called
                res = Math.max(res,permute(arr1, arr2,l+1, r));

                //backtrack
                swap(arr2,l,i);
            }
            return res;
        }

    }

}
