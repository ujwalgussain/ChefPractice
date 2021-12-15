import java.util.*;
import java.util.stream.Collectors;


class TestClass1 {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static public void display(ListNode head) {
        ListNode temp = head;
        if (head == null)
            System.out.println("null");
        while (temp != null) {
            System.out.printf(temp.val + " ");
            temp = temp.next;
        }
    }

    static ListNode createList(int... val) {
        ListNode head = null;
        ListNode temp = head;
        for (int i : val) {
            if (head == null) {
                head = new ListNode(i);
                temp = head;
            } else {
                temp.next = new ListNode(i);
                temp = temp.next;
            }
        }
        return head;
    }

    public ListNode reverse(ListNode A) {
        if (A == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;
        for (int i = 0; i < 2 && curr != null; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if (curr != null)
            A.next = reverse(curr);
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new TestClass1().solve(2,new ArrayList<>(List.of(
                new ArrayList<>(List.of(1,2))
        ))));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    int check(TreeNode A)
    {
        if(A==null)
            return 0;
        int left = check(A.left);
        if(left==-1)
            return -1;
        int right = check(A.right);
        if(right==-1)
            return -1;
        if(Math.abs(left-right)>1)
            return -1;
        return 1+Math.max(left,right);

    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer,HashSet<Integer>> adjList = new HashMap<>();
        for(ArrayList<Integer> entry : B){
            Integer u = entry.get(0), v= entry.get(1);
            if(adjList.containsKey(u)){
                adjList.get(u).add(v);
            }else{
                HashSet<Integer> set = new HashSet<>();
                set.add(v);
                adjList.put(u,set);
            }
            if(adjList.containsKey(v)){
                adjList.get(v).add(u);
            }else{
                HashSet<Integer> set = new HashSet<>();
                set.add(u);
                adjList.put(v,set);
            }
        }
        find(adjList,new HashSet<>(),1);
        return res;
    }
    static int res = 0;
    public int find(HashMap<Integer,HashSet<Integer>> adjList, HashSet<Integer> visited, Integer root){
        visited.add(root);
        int count = 0;
        for(Integer v : adjList.get(root)){
            if(visited.contains(v))
                continue;
            int subres = find(adjList,visited,v);
            if((subres&1)==0)
                res++;
            else
                count+=subres;
        }
        return 1+count;
    }
    public static void merge(long arr1[], long arr2[], int n, int m)
    {
        // code here
        for(int i=m;i>=0;i--){
            long last = arr1[n-1];
            int j;
            for(j=n-1;j>=0 && arr1[j]>arr2[i];i--)
                arr1[j+1]=arr1[j];
            if(j!=n-1 || last>arr2[i]){
                arr1[j]=arr2[i];
                arr2[i]=last;
            }
        }
    }
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        Stack<Integer> stack = new Stack<>();
        for(int i:arr){
            while(!stack.isEmpty() && stack.peek()<=i)
                stack.pop();
            stack.push(i);
        }
        ArrayList<Integer> result = new ArrayList<>(stack);
        Collections.reverse(result);
        return result;
    }
}
