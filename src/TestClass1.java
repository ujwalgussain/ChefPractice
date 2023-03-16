import com.sun.source.tree.Tree;

import java.math.BigInteger;
import java.util.*;


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

    int test() {
        try {
            return 0;
        } catch (Exception ex) {
            System.out.println();
        } finally {
            System.out.println("finally");
        }
        return 1;

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

    int check(TreeNode A) {
        if (A == null)
            return 0;
        int left = check(A.left);
        if (left == -1)
            return -1;
        int right = check(A.right);
        if (right == -1)
            return -1;
        if (Math.abs(left - right) > 1)
            return -1;
        return 1 + Math.max(left, right);

    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();
        for (ArrayList<Integer> entry : B) {
            Integer u = entry.get(0), v = entry.get(1);
            if (adjList.containsKey(u)) {
                adjList.get(u).add(v);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(v);
                adjList.put(u, set);
            }
            if (adjList.containsKey(v)) {
                adjList.get(v).add(u);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(u);
                adjList.put(v, set);
            }
        }
        find(adjList, new HashSet<>(), 1);
        return res;
    }

    static int res = 0;

    public int find(HashMap<Integer, HashSet<Integer>> adjList, HashSet<Integer> visited, Integer root) {
        visited.add(root);
        int count = 0;
        for (Integer v : adjList.get(root)) {
            if (visited.contains(v))
                continue;
            int subres = find(adjList, visited, v);
            if ((subres & 1) == 0)
                res++;
            else
                count += subres;
        }
        return 1 + count;
    }

    public static void merge(long arr1[], long arr2[], int n, int m) {
        // code here
        for (int i = m; i >= 0; i--) {
            long last = arr1[n - 1];
            int j;
            for (j = n - 1; j >= 0 && arr1[j] > arr2[i]; i--)
                arr1[j + 1] = arr1[j];
            if (j != n - 1 || last > arr2[i]) {
                arr1[j] = arr2[i];
                arr2[i] = last;
            }
        }
    }

    static ArrayList<Integer> leaders(int arr[], int n) {
        // Your code here
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            while (!stack.isEmpty() && stack.peek() <= i)
                stack.pop();
            stack.push(i);
        }
        ArrayList<Integer> result = new ArrayList<>(stack);
        Collections.reverse(result);
        return result;
    }

    public int solve(TreeNode A, int B) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        HashMap<Integer, TreeNode> parentMap = new HashMap<>();
        TreeNode targetNode = null;
        int nodes = 0;
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            nodes++;
            if (currNode.val == B)
                targetNode = currNode;
            if (currNode.left != null) {
                queue.add(currNode.left);
                parentMap.put(currNode.left.val, currNode);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
                parentMap.put(currNode.right.val, currNode);
            }
        }
        int ans = 0;
        HashSet<TreeNode> burnedNodes = new HashSet<>();
        queue.add(targetNode);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean f = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && !burnedNodes.contains(curr.left)) {
                    f = true;
                    burnedNodes.add(curr.left);
                    queue.add(curr.left);
                }
                if (curr.right != null && !burnedNodes.contains(curr.right)) {
                    f = true;
                    burnedNodes.add(curr.right);
                    queue.add(curr.right);
                }
                TreeNode parent = parentMap.get(curr.val);
                if (parent != null && !burnedNodes.contains(curr.left)) {
                    f = true;
                    burnedNodes.add(parent);
                    queue.add(parent);
                }
            }
            if (f) {
                ans++;
            }
        }
        return ans;

    }

    public int minDepth(TreeNode A) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);
        int depth = 0;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                depth++;
            }
            if (curr.left == null && curr.right == null)
                break;
            if (curr != null) {
                if (curr.left == null && curr.right == null) break;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return depth + 1;
    }

    public int sumNumbers(TreeNode A) {
        util(A, new LinkedList<>());
        return result;
    }

    int result = 0;

    public void util(TreeNode A, LinkedList<String> list) {
        if (A == null)
            return;
        else {
            list.add(A.val + "");
            if (A.left == null && A.right == null) {
                /*String numberStr = "";
                for (int i = list.size()-1; i >= Math.max(0,list.size()-5); i++) {
                    numberStr=numberStr.concat(list.get(i));
                }*/
                BigInteger bigInteger = new BigInteger(list.stream().reduce("", (x, y) -> x + y));
                bigInteger = bigInteger.mod(BigInteger.valueOf(1003));

                result = ((result % 1003) + bigInteger.intValue()) % 1003;
            } else {
                util(A.left, list);
                util(A.right, list);
            }
            list.pollLast();
        }
    }

    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeLinkNode curr = queue.poll();
            if (curr == null) {
                if (!queue.isEmpty())
                    queue.add(null);
            } else {
                curr.next = queue.peek();
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
        }
    }

    public TreeNode constructBST(ArrayList<Integer> preOrder) {
        ArrayList<Integer> inorder = new ArrayList<>(preOrder);
        Collections.sort(inorder);
        return createBSTFromInorderAndPreOrder(inorder, preOrder, 0, inorder.size() - 1);


    }

    public TreeNode createBSTFromInorderAndPreOrder(ArrayList<Integer> inorder, ArrayList<Integer> preOrder, int lo, int hi) {
        if (lo > hi)
            return null;
        TreeNode root = new TreeNode(preOrder.get(preIdx++));
        if (lo == hi)
            return root;
        int inOrderIdx = getInorderIdx(inorder, root.val, lo, hi);
        root.left = createBSTFromInorderAndPreOrder(inorder, preOrder, lo, inOrderIdx - 1);
        root.right = createBSTFromInorderAndPreOrder(inorder, preOrder, inOrderIdx + 1, hi);
        return root;
    }

    int getInorderIdx(ArrayList<Integer> inorder, int target, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            if (inorder.get(i) == target)
                return i;
        }
        return -1;
    }

    int preIdx = 0;

    boolean notInRange(int x, int lo, int hi) {
        return x < lo || x > hi;
    }

    public static void main(String[] args) {
        TreeNode root = new TestClass1().new TreeNode(3);
        new TestClass1().createBSTFromPreOrder(root,
                new ArrayList<Integer>(List.of(1,2,7,6,17,15,9,10,18)),
                Integer.MIN_VALUE, Integer.MAX_VALUE);
        return;
    }

    void createBSTFromPreOrder(TreeNode curr, ArrayList<Integer> preOrder, int lo, int hi) {
        if (preIdx == preOrder.size() || notInRange(preOrder.get(preIdx), lo, hi))
            return;
        if (preOrder.get(preIdx) < curr.val) {
            curr.left = new TreeNode(preOrder.get(preIdx++));
            createBSTFromPreOrder(curr.left, preOrder, lo, curr.val - 1);
        }
        if (preIdx == preOrder.size() || notInRange(preOrder.get(preIdx), lo, hi))
            return;
        curr.right = new TreeNode(preOrder.get(preIdx++));
        createBSTFromPreOrder(curr.right, preOrder, curr.val + 1,hi);
    }

    public ArrayList<Integer> verticalSum(TreeNode A) {
        TreeMap<Integer,Integer> sumMap = new TreeMap<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> verticalIdx = new LinkedList<>();
        list.add(A);
        verticalIdx.add(0);
        while(!list.isEmpty()) {
            TreeNode curr = list.poll();
            int currIdx = verticalIdx.poll();
            sumMap.compute(currIdx, (k, v) -> (v == null ? 0 : v) + curr.val);
            if (curr.left != null)
                list.add(curr.left);
            if (curr.right != null)
                list.add(curr.right);
        }
        return new ArrayList<>(sumMap.values());
    }

    public Long coveredNodes(TreeNode A) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(A);
        long total = 0;
        int level = 0;
        HashMap<Integer, TreeNode> leftView = new HashMap<>();
        HashMap<Integer, TreeNode> rightView = new HashMap<>();

        while(!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = list.poll();
                if(!leftView.containsKey(level)) {
                    leftView.put(level, curr);
                } else {
                    rightView.put(level,curr);
                }
                total+=curr.val;
                if (curr.left != null)
                    list.add(curr.left);
                if (curr.right != null)
                    list.add(curr.right);
            }
            level++;
        }
        long leftViewTotal = leftView.values().stream().map(treeNode -> treeNode.val).reduce(0,(x,y) -> x+y);
        long rightViewTotal = rightView.values().stream().map(treeNode -> treeNode.val).reduce(0,(x,y) -> x+y);
        return total-leftViewTotal-rightViewTotal;
    }

}
