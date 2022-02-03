package a_practiceproblems;

import a_practiceproblems.TreeProblems.tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class TestClass3 {
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (newInterval.start > newInterval.end) {
            newInterval = new Interval(newInterval.end, newInterval.start);
        }
        TreeSet<Interval> treeSet = new TreeSet<>((x, y) -> x.start - y.start);
        treeSet.addAll(intervals);
        treeSet.add(newInterval);
        Stack<Interval> stack = new Stack<>();
        stack.add(intervals.get(0));
        for (Interval currInterval : treeSet) {
            Interval top = stack.peek();
            int topEnd = top.end;
            if (topEnd < currInterval.start)
                stack.push(currInterval);
            else
                top.end = Math.max(topEnd, currInterval.start);

        }
        return stack.stream().collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int arr[][] = new int[A][A];
        int c = 1;
        int left = 0, right = A - 1;
        int top = left, bottom = A - 1;
        int dir = 0;
        while (top <= bottom && left <= right) {
            switch (dir) {
                case 0:
                    for (int i = left; i <= right; i++)
                        arr[top][i] = c++;
                    top++;
                    break;
                case 1:
                    for (int i = top; i <= bottom; i++)
                        arr[i][right] = c++;
                    right--;
                    break;
                case 2:
                    for (int i = right; i >= left; i--)
                        arr[bottom][i] = c++;
                    bottom--;
                    break;
                case 3:
                    for (int i = bottom; i >= top; i--)
                        arr[i][left] = c++;
                    left++;
                    break;
            }
            dir = (dir + 1) % 4;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int[] a : arr) {
            ArrayList<Integer> subres = new ArrayList<>();
            for (int i : a) {
                subres.add(i);
            }
            result.add(subres);
        }
        return result;
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        class Node {
            int elem, i, j;

            public Node(int elem, int i, int j) {
                this.elem = elem;
                this.i = i;
                this.j = j;
            }
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(new Node(arr[0][i], 0, i));
        }
        while (priorityQueue.peek().elem != Integer.MAX_VALUE) {
            Node curr = priorityQueue.poll();
            ans.add(curr.elem);
            if (curr.j > arr[curr.i].length)
                priorityQueue.add(new Node(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
            else
                priorityQueue.add(new Node(arr[curr.i][curr.j + 1], curr.i, curr.j + 1));
        }
        return ans;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(')
                        return false;
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{')
                        return false;
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[')
                        return false;
                    stack.pop();
                    break;
            }

        }
        return stack.isEmpty();
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permute(nums, new ArrayList<>(), new boolean[nums.length]);
        return new ArrayList<>(set);
    }

    ArrayList<List<Integer>> set = new ArrayList<>();

    public void permute(int[] nums, List<Integer> permutation, boolean used[]) {
        if (permutation.size() == nums.length)
            set.add(new ArrayList<>(permutation));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i])
                    continue;
                permutation.add(nums[i]);
                used[i] = true;
                permute(nums, permutation, used);
                permutation.remove(permutation.size() - 1);
                used[i] = false;
                while (i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;
            }
        }
    }


    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public String simplifyPath(String A) {
        /*
         * If currStr is . or empty then move ahead
         * If currStr is .. then just pop the top only if it is not empty
         * else push*/
        String[] arr = A.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (s.equals("") || s.equals("."))
                continue;
            if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
                continue;
            }
            //This means s is folder name
            stack.push(s);
        }
        return ("/" + stack.stream().collect(Collectors.joining("/")));
    }

    public void setZeroes(int[][] matrix) {

        //optimized,in-place, 0(2*((m*n)) time, space 1
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        rec(new ArrayList<>(), 1, n, k);
        return combinations;
    }

    List<List<Integer>> combinations = new ArrayList<>();

    public void rec(List<Integer> list, int start, int n, int k) {
        if (list.size() == k) {
            combinations.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            rec(list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        subsets.add(new ArrayList<>());
        generateSubsets(nums, 0, new ArrayList<>());
        return subsets;
    }

    List<List<Integer>> subsets = new ArrayList<>();

    public void generateSubsets(int nums[], int idx, List<Integer> list) {
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            subsets.add(new ArrayList<>(list));
            generateSubsets(nums, i + 1, list);
            list.remove(list.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }

    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (solve(board, new boolean[m][n], word, i, j, m, n, 0))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean solve(char[][] board, boolean vis[][], String word, int i, int j, int rows, int cols, int strIdx) {
        if (strIdx == word.length())
            return true;
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        if (vis[i][j])
            return false;
        if (board[i][j] == word.charAt(strIdx)) {
            vis[i][j] = true;
            boolean ans = solve(board, vis, word, i, j - 1, rows, cols, strIdx + 1) ||
                    solve(board, vis, word, i, j + 1, rows, cols, strIdx + 1) ||
                    solve(board, vis, word, i + 1, j, rows, cols, strIdx + 1) ||
                    solve(board, vis, word, i - 1, j, rows, cols, strIdx + 1);
            vis[i][j] = false;
            return ans;
        }
        return false;
    }

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2])
                nums[j++] = nums[i];
        }
        nums[nums.length - 2] = nums[j++];
        nums[nums.length - 1] = nums[j++];
        return j;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> idxStack = new Stack<>();
        int i = 0, maxArea = -1;
        for (; i < heights.length; i++) {
            while (!idxStack.isEmpty() && heights[idxStack.peek()] >= heights[i]) {
                int pop = idxStack.pop();
                int area = heights[pop] * (idxStack.isEmpty() ? i : i - idxStack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            idxStack.push(i);
        }
        while (!idxStack.isEmpty()) {
            int pop = idxStack.pop();
            int area = heights[pop] * (idxStack.isEmpty() ? i : i - idxStack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public int maximalSquare(char[][] matrix) {
        /*
        Intialize 1st row and 1st col of dp[][]-> If m[i][j]==1 then 1 else 0;

        for i = 1 to rows
            for j=1 to cols
                m[i][j]==1 == 1 then dp[i][j]= 1 + min(top,diag-left, bottom)
        Note the maxValue in dp[][] is size of square
         */
        int m = matrix.length, n = matrix[0].length;
        boolean f = false;
        int dp[][] = new int[m][n];
        //Fill Rows
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                f = true;
            } else
                dp[0][i] = 0;
        }
        //Fill Cols
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                f = true;
                dp[i][0] = 1;
            } else
                dp[i][0] = 0;
        }
        int ans = -1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    f = true;
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], //diag left
                            Math.min(
                                    dp[i - 1][j], //top
                                    dp[i][j - 1] //left
                            )
                    );

                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans == 0 ? !f ? 0 : 1 : ans << 1;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode tail1 = dummy1;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode first = null;
        ListNode prev = dummyhead;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val >= x) {
                //move temp to end;
                if (first == null)
                    first = temp;
                prev.next = temp.next;
                temp.next = null;
                tail1.next = temp;
                tail1 = tail1.next;
                temp = prev.next;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        if (prev == dummyhead) {
            return dummy1.next;
        }
        if (tail1 != dummy1) {
            prev.next = dummy1.next;
        }
        return dummyhead.next;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        int n = s.length();
        for (int i = 1; i <= 3; i++) {
            int len1 = Math.min(i + 3, n);
            for (int j = i + 1; j <= len1; j++) {
                int len2 = Math.min(j + 3, n);
                for (int k = j + 1; k <= len2; k++) {
                    String p1 = "", p2 = "", p3 = "", p4 = "";
                    if (isValidIp((p1 = s.substring(0, i))) && isValidIp((p2 = s.substring(i, j))) && isValidIp((p3 = s.substring(j, k))) && isValidIp((p4 = s.substring(k))))
                        list.add(p1 + "." + p2 + "." + p3 + "." + p4);
                }
            }
        }
        return list;
    }

    public boolean isValidIp(String s) {
        if (s.length() == 0 || s.length() > 3)
            return false;
        int no = Integer.parseInt(s);
        if (no == 0 && s.length() == 0)
            return true;
        if (no > 0 && no <= 255 && s.charAt(0) != '0')
            return true;
        return false;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        return createNode(postorder, inorder, 0, inorder.length - 1);
    }

    int postIdx;

    TreeNode createNode(int[] postorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postIdx--]);
        if (inStart == inEnd)
            return root;
        int inIdx = inStart;
        for (; inIdx <= inEnd; inIdx++) {
            if (inorder[inIdx] == root.val)
                break;
        }
        root.right = createNode(postorder, inorder, inStart, inIdx - 1);
        root.left = createNode(postorder, inorder, inIdx + 1, inEnd);
        return root;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>(List.of(1));
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>(List.of(1));
            for (int j = 1; j < prev.size(); j++) {
                curr.add(prev.get(i - 1) + prev.get(i));
            }
            curr.add(1);
            prev = curr;
        }
        return prev;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        //return min(triangle,0,0);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            int n = triangle.get(i).size();
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public int min(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size())
            return 0;
        if (j == triangle.get(i).size())
            return Integer.MAX_VALUE;
        return triangle.get(i).get(j) + Math.min(min(triangle, i + 1, j), min(triangle, i + 1, j + 1));
    }


    public int maxProfit(int[] prices) {
        int n = prices.length;
        int t[] = new int[n];
        t[0] = 0;
        t[n - 1] = prices[n - 1];
        int minFront = prices[0];
        int maxProfitFront = 0;
        for (int i = 1; i < n; i++) {
            maxProfitFront = Math.max(t[i - 1], prices[i] - minFront);
            minFront = Math.min(minFront, prices[i]);
            t[i] = maxProfitFront;
        }
        int maxBack = prices[n - 1];
        int ans = 0;
        int maxProfitBack = 0;
        for (int i = n - 2; i >= 0; i--) {
            maxProfitBack = Math.max(maxProfitBack, maxBack - prices[i]);
            maxBack = Math.max(maxBack, prices[i]);
            t[i] += maxProfitBack;
            ans = Math.max(ans, t[i]);
        }
        return ans;
    }

    public boolean isPalindrome(String s) {
        String string = Arrays.stream(s.split("\\s")).map(x -> {
            x = x.toLowerCase();
            String formatted = "";
            for (char c : x.toCharArray()) {
                if (Character.isLetterOrDigit(c))
                    formatted += c;
            }
            return formatted;
        }).filter(x -> !x.equals("")).collect(Collectors.joining());
        if (string.equals(""))
            return true;
        int n = string.length();
        for (int i = 0; i < n / 2; i++) {
            if (string.charAt(i) != string.charAt(n - i - 1))
                return false;
        }
        return true;
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] minCutUptoI = new int[s.length()]; // minCutUptoI[i] means the minumum cuts needed for a palindrome partitioning of s.substring(0, i+1).

        for (int i = 0; i < s.length(); i++) {
            minCutUptoI[i] = i; // base case -> the maximum cut needed to cut the s.substring(0, i + 1) is i -> in case of no palindromes in substring (remember single char is also a palindrome )
        }
        System.out.println("Base Case : " + Arrays.toString(minCutUptoI));

        for (int mid = 0; mid < s.length(); mid++) { // iterate through all chars as mid point of palindrome
            System.out.println("Mid - " + mid);
            // CASE 1. odd len: center is at index mid, expand on both sides
            for (int start = mid, end = mid; start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end); start--, end++) {
                System.out.println("\t" + start + "-" + end + " " + Arrays.toString(minCutUptoI));
                int minCutUptoEnd = (start == 0) ? 0 : minCutUptoI[start - 1] + 1; // if start has reached 0, means that s.substring(0, end + 1) is palindrome and so NO cut is required (that is why 0) otherwise CUTS require upto substring(0, start) and + 1 because of the substring between start and end needed that 1 cut
                minCutUptoI[end] = Math.min(minCutUptoEnd, minCutUptoI[end]);
            }

            // CASE 2: even len: center is between [mid-1,mid], expand on both sides
            for (int start = mid - 1, end = mid; start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end); start--, end++) {
                System.out.println("\t" + start + "-" + end + " " + Arrays.toString(minCutUptoI));
                int minCutUptoEnd = (start == 0) ? 0 : minCutUptoI[start - 1] + 1;
                minCutUptoI[end] = Math.min(minCutUptoEnd, minCutUptoI[end]);
            }
        }

        return minCutUptoI[s.length() - 1];
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        LinkedList<Node> list = new LinkedList<>();
        HashMap<Node, Node> copyNodeMap = new HashMap<>();
        copyNodeMap.put(node, new Node(node.val));
        list.add(node);
        while (!list.isEmpty()) {
            Node curr = list.poll();
            Node copyNode = copyNodeMap.get(curr);
            for (Node neighbor : curr.neighbors) {
                Node copyNeighbor = null;
                if (copyNodeMap.containsKey(neighbor))
                    copyNeighbor = copyNodeMap.get(neighbor);
                else {
                    copyNeighbor = new Node(neighbor.val);
                    list.add(neighbor); //mark as visited
                    copyNodeMap.put(neighbor, copyNeighbor);
                }
                copyNode.neighbors.add(copyNeighbor);
            }
        }
        return copyNodeMap.get(node);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (n == 1)
            return gas[0] >= cost[0] ? 0 : -1;
        //Travel from i to i+1 we will spend gas[i] - cost[i]..then at i+1 tank will be refilled with gas[i+1]
        for (int i = 0; i < n; i++) {
            int tank = 0;
            boolean empty = false;
            for (int j = i; j < n + i; j++) {
                int curr = j % n;
                tank += (gas[curr] - cost[curr]); //tank must always have some gas left to go forward
                if (tank < 0) {
                    empty = true;
                    break;
                }
            }
            if (!empty)
                return i;
        }
        return -1;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token :
                tokens) {
            if (token.length() == 1 && !Character.isLetterOrDigit(token.charAt(0))) {
                //symbol
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int ans = 0;
                switch (token) {
                    case "+":
                        ans = operand1 + operand2;
                        break;
                    case "-":
                        ans = operand1 - operand2;
                        break;
                    case "*":
                        ans = operand1 * operand2;
                    case "/":
                        ans = operand1 / operand2;
                }
                stack.push(ans);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    public String reverseWords(String s) {
        String arr[] = s.split("\\s+");
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            String tmp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = arr[i];
        }
        return Arrays.stream(arr).collect(Collectors.joining(" "));
    }

    public int maxProduct(int[] nums) {
        //https://www.geeksforgeeks.org/maximum-product-subarray-set-3/
        int maxValue, minValue, maxProduct;
        maxValue = minValue = maxProduct = nums[0];
        for (int num :
                nums) {
            if (num < 0) {
                //swap minValue and maxValue
                int temp = minValue;
                minValue = maxValue;
                maxValue = temp;
            }
            maxValue = Math.max(num, num * maxValue);
            minValue = Math.min(num, num * minValue);
            maxProduct = Math.max(maxProduct, maxValue);
        }
        return maxProduct;
    }

    public int findMin(int[] nums) {
        /*
        //Linear Search
        int n = nums.length;
        if(n==1)
            return nums[0];
        //array is not rotated
        if(nums[0]<nums[n-1])
            return nums[0];
        int i = 0;
        while(i<n-1 && nums[i]<nums[i+1]){
            i++;
        }

        return nums[i+1];*/

        /*
        Binary Search :
        Find if mid element is smaller than both its neighbours if it is then its answer;
        If not check where to go?
            left? if right array is sorted i.e. nums[mid] <= nums[high]
            right? if left array is sorted i.e. nums[low] <= nums[mid]
         */
        int n = nums.length;
        if (n == 1)
            return nums[0];
        //array is not rotated
        if (nums[0] < nums[n - 1])
            return nums[0];
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] <= nums[(mid + 1) % n] //if mid < next sorted elem
                    &&
                    nums[(mid - 1 + n) % n] >= nums[mid]) { //if prev sorted elem is greater than mid
                return nums[mid];
            } else {
                if (nums[mid] < nums[hi]) //mid to hi is already sorted....hence ans will be in unsorted part...
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
        }
        return -1;
    }

    public int maximumGap(int[] nums) {
        /*TreeSet<Integer> set = new TreeSet<>();
        Arrays.stream(nums).forEach(set::add);
        int ans = Integer.MIN_VALUE;
        for (int num:
             nums) {
            Integer lowerKey = set.lower(num);
            if(lowerKey!=null){
                ans= Math.max(ans,num-lowerKey);
            }
        }
        return ans;*/
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int m = arr1.length, n = arr2.length;
        int i = 0;
        for (; i < Math.min(m, n); i++) {
            int v1 = Integer.parseInt(arr1[i]);
            int v2 = Integer.parseInt(arr2[i]);
            if (v1 > v2)
                return 1;
            if (v1 < v2)
                return -1;
        }
        //One of the arr is larger
        if (m > n) {
            //if anything except zero is found then v1 is greater
            for (; i < m; i++) {
                if (Integer.parseInt(arr1[i]) != 0)
                    return 1;
            }
        } else {
            //if anything except zero is found then v2 is greater
            for (; i < m; i++) {
                if (Integer.parseInt(arr2[i]) != 0)
                    return -1;
            }
        }
        return 0;
    }

    class BSTIterator {
        TreeNode curr;
        int next = -1;

        public BSTIterator(TreeNode root) {
            curr = root;
            setNext();
        }

        private void setNext() {
            if (curr.left == null) {
                next = curr.val;
                curr = curr.right;
                return;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == curr) {
                    pred.right = null;
                    next = curr.val;
                    curr = curr.right;
                    return;
                } else {
                    pred.right = curr;
                    curr = curr.left;
                }
            }
        }

        public int next() {
            int n = curr.val;
            setNext();
            return n;
        }

        public boolean hasNext() {
            return curr != null;
        }
    }


    public int countPrimes(int n) {
        if (n <= 2)
            return 0;

        boolean[] arr = new boolean[n];
        for (int i = 3; i <= n / 2; i += 2) {
            for (int j = 3; i * j < n; j += 2) {
                arr[i * j] = true;
            }
        }
        int c = 1; //2 is prime
        for (int i = 3; i < n; i += 2) { //only odds can be prime
            if (arr[i] == false)
                c++;
        }
        return c;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] prerequisite :
                prerequisites) {
            adjList.compute(prerequisite[0], (key, value) -> {
                if (value == null) {
                    return new ArrayList<>(List.of(prerequisite[1]));
                } else {
                    value.add(prerequisite[1]);
                    return new ArrayList<>(value);
                }
            });
        }
        Color[] color = new Color[numCourses];
        Arrays.fill(color, Color.White);
        for (Integer i : adjList.keySet()) {
            if (color[i] == Color.White)
                if (hasCycle(adjList, color, i))
                    return false;
        }
        return true;
    }

    enum Color {Gray, White, Black}

    public boolean hasCycle(HashMap<Integer, List<Integer>> adjList, Color[] colors, int currVertex) {
        colors[currVertex] = Color.Gray;
        if (adjList.get(currVertex) != null) {
            for (Integer neighbor : adjList.get(currVertex)) {
                if (colors[neighbor] == Color.Gray) //this was already visited..hence cycle detected
                    return true;
                if (colors[neighbor] == Color.White && hasCycle(adjList, colors, neighbor))
                    return true;
            }
        }
        colors[currVertex] = Color.Black;
        return false;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int[] alphabets = new int[26];
        String str = Arrays.toString(alphabets);
        List<Integer> answer = new ArrayList<>();
        int len = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                alphabets[c - 'a']++;
                len++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alphabets[c - 'a']--;
            if (i >= len) {
                //remove start from curr Window
                alphabets[s.charAt(i - len) - 'a']++;
            }
            if (Arrays.toString(alphabets).equals(str))
                answer.add(i - len + 1);
        }
        return answer;
    }

    public int sumSubarrayMins(int[] arr) {
        //Similar to Largest Rectangle in Histogram
        /*Ex:   2   9   7   8   3   4   6   1
                Considering 3,
                9   7   8   3   4   6  will generate the sub arrays having 3 as min
                    starting from  subarray 9   7   8   3
                let g1 = no of elements before 3 and g2 = no of elements after 3
                No of subarrays with min as 3 is g1+1 * g2+1
                Stack will look like this
                2   9   7   8   3   4   6   1
                peek           pop          i -> g1+1 = pop-top after pop and g2+1 = i-pop
                if stack is empty then start = -1;
         */
        int N = arr.length;
        int MOD = 1000000007;
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int poppedIdx = stack.pop();
                int startIdx = stack.isEmpty() ? -1 : stack.peek();
                result = (result +
                        ((long) arr[poppedIdx] % MOD *
                                (long) (i - poppedIdx) % MOD * (long) (poppedIdx - startIdx) % MOD)) % MOD;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int pkIdx = stack.pop();
            int startIdx = stack.isEmpty() ? -1 : stack.peek();
            result = (result + ((long) arr[pkIdx] % MOD * (long) (N - pkIdx) % MOD * (long) (pkIdx - startIdx) % MOD)) % MOD;
        }
        return (int) result % MOD;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int n = nums.length;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int end = 0; end < n; end++) {
            sum += nums[end];
            while (sum >= target) {
                System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start, end)) + " " + sum);
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start++];
            }
        }
        return minLength;
    }

    public int longestkSubstr(String s, int k) {
        // code here
        int a[] = new int[26];
        int dist = 0, start = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i);
            a[curr - 'a']++;
            if (a[curr - 'a'] == 1)
                dist++;
            while (dist > k) {
                //move start
                char startChar = s.charAt(start++);
                a[startChar - 'a']--;
                if (a[startChar - 'a'] == 0)
                    dist--;
            }
            if (dist == k) {
                System.out.println(s.substring(start, i + 1));
                maxLength = Math.max(maxLength, i - start);
            }
        }
        return maxLength;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
                cnt++;
            if (cnt == 2)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            //Remove all smaller elements from the tail
            while (!list.isEmpty() && nums[list.peekLast()] < nums[i]) {
                list.pollLast();
            }
            //insert
            list.add(i);
            if (i >= k - 1) {
                ans[i - (k - 1)] = nums[list.peekFirst()];
                //Removing first Element of current window
                if (!list.isEmpty() && list.peekFirst() == i - (k - 1)) {
                    list.pollFirst();
                }
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public int longestSubstring(String s, int k) {
        /*
        Count occurence of each char in str
        Scan each char
            if occurence of char is less than k
            we have 2 places where we can find the answer ie., answer can be before char or after char
            repeat the same process
         Ex : aaabccc
              after b answer can be in aaa or ccc
         Ex : aabccca
              after b answer can be in aaa or ccca...
         */
        return helper(s, 0, s.length() - 1, k);
    }

    public int helper(String s, int start, int end, int k) {
        if (end - start + 1 < k)
            return 0;
        int freq[] = new int[26];
        for (int i = start; i <= end; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = start; i <= end; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                //invalid character
                int j = i;
                while (j <= end && freq[s.charAt(j) - 'a'] < k) {
                    j++;
                }
                return Math.max(
                        helper(s, start, i - 1, k),
                        helper(s, j, end, k)
                );
            }

        }
        return end - start + 1;
    }

    public int characterReplacement(String s, int k) {
        /*
        for any substring, replacements will be substr len - count of maxOccuring Char.
        Hence window will become invalid if replacements exceed k..so we need to move start forward
         */
        int maxLength = 0;
        int maxCount = 0;
        int freq[] = new int[26];
        for (int end = 0, start = 0; end < s.length(); end++) {
            int count = ++freq[s.charAt(end) - 'a'];
            maxCount = Math.max(maxCount, count);
            while (end - start - maxCount < k) {
                --freq[s.charAt(start++) - 'a'];
            }
            //Valid substring found - start will be at position from where we will require <= k replacements
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    static long inversionCount(long arr[], long N) {
        // Your Code Here
        TreeMap<Long, Integer> map = new TreeMap<>();
        long count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            SortedMap<Long, Integer> headMap = map.headMap(arr[i]);
            count += headMap.values().stream().reduce(0, (x, y) -> x + y) - headMap.getOrDefault(arr[i], 0);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }

    public static void solution(int []arr){
// write your code here
        int n = arr.length;

        List<List<Integer>>[] lists = new ArrayList[n];
        for (int i = 0;i<n;i++) {
            List<Integer> al = new ArrayList<>(List.of(arr[i]));
            lists[i] = new ArrayList(al);
        }
        int max = 0;
        List<List<Integer>> maxLIS = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j] && lists[i].get(0).size()<=lists[j].get(0).size()+1){
                    lists[i] = new ArrayList<>();
                    for(List<Integer> l : lists[j]){
                        l.add(arr[j]);
                        lists[i].add(new ArrayList<>(l));
                        if(lists[i].get(0).size()>max){
                            maxLIS = lists[i];
                        }
                    }
                }
            }
        }

        System.out.println(maxLIS);
    }

    public static void main(String[] args) {
        solution(new int[]{10,22,9,33,21,50,41,60,80,1});
    }
}
